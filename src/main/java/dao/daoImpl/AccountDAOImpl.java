package dao.daoImpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.AccountDAOInterface;
import entity.Account;
import service.HibernateSessionFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAOInterface {

    public void create(Account account) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.save(account);
        tr.commit();
        session.close();
    }

    public Account getById(int accountId) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Account account = (Account) session.load(Account.class, accountId);
        session.close();
        return account;
    }

    public List<Account> getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Account.class);
        return criteria.list();
    }

    public void update(Account account) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.update(account);
        tr.commit();
        session.close();
    }

    public void delete(int accountId) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.delete(session.get(Account.class, accountId));
        tr.commit();
        session.close();
    }
}