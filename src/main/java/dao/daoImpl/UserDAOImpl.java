package dao.daoImpl;

import org.hibernate.Criteria;
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
        Criteria criteria = session.createCriteria(User.class);
        criteria.createCriteria("SELECT u FROM User u WHERE u.userId IN (SELECT a.userId FROM Account a GROUP BY a.userId HAVING SUM(a.account) >= ALL (SELECT SUM(a2.account) FROM Account a2 GROUP BY a2.userId))");

        return (User) criteria.uniqueResult();
    }
}

