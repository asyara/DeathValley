package dao.daoImpl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.UserDAOInterface;
import entity.User;
import service.HibernateSessionFactory;
import java.util.List;

public class UserDAOImpl implements UserDAOInterface {


    public void create(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.save(user);
        tr.commit();
        session.close();
    }

    public User getById(int userId) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        User user = (User) session.load(User.class, userId);
        session.close();
        return user;
    }

    public List<User> getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(User.class);
        List users = criteria.list();
        return users;
    }

    public void update(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.update(user);
        tr.commit();
        session.close();
    }

    public void delete(int userId) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.delete(session.get(User.class, userId));
        tr.commit();
        session.close();
    }

    public User getRichestUser() {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery(
                "SELECT u FROM User u " +
                        "WHERE userId IN (" +
                        "SELECT accountId FROM Account GROUP BY userId HAVING SUM(account) >= ALL (" +
                        "SELECT SUM(account) FROM Account GROUP BY userId))");
        List str = query.list();
        User user = (User) str.get(0);
        return user;
    }
}

