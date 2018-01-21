package service;
import dao.daoImpl.AccountDAOImpl;
import dao.daoImpl.UserDAOImpl;
import entity.Account;
import entity.User;
import java.util.ArrayList;

public class Service {

    public Service() {
    }


    public ArrayList<Account> getAllAccounts() {
        AccountDAOImpl accDao = new AccountDAOImpl();
        return accDao.getAll();

    }

    public User getRichestUser() {
        UserDAOImpl userDAO = new UserDAOImpl();
        return userDAO.getRichestUser();
    }

    public int getAccountsSum() {
        ArrayList <Account> accounts = getAllAccounts();
        int sum = 0;
        for (Account acc : accounts) {
            sum += acc.getAccount();
        }
        return sum;
    }
}
