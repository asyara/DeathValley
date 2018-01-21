package dao;

import entity.Account;

import java.util.List;

public interface AccountDAOInterface extends DAOInterface <Account> {

    List<Account> getAll();

}
