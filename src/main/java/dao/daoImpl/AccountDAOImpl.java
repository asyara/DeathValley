package dao.daoImpl;

import service.DBconnect;
import dao.AccountDAOInterface;
import entity.Account;
import java.sql.*;
import java.util.ArrayList;

public class AccountDAOImpl implements AccountDAOInterface {

    private DBconnect connect;

    public AccountDAOImpl() {
        this.connect = new DBconnect();
    }

    public void create(Account account) {
        String sql = "INSERT INTO account VALUES(" + account.getAccountId() + "," + account.getAccount() + "," + account.getUserId() + ");";
        try {
            PreparedStatement ps = connect.getConnection().prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account getById(int id) {
        Account account = new Account();
        String sql = "SELECT * FROM account WHERE accountId=" + id + ";";
        try {
            PreparedStatement ps = connect.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                account.setAccountId(rs.getInt("accountId"));
                account.setAccount(rs.getInt("account"));
                account.setUserId(rs.getInt("userId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return account;
    }

    public ArrayList<Account> getAll() {
        ArrayList<Account> accountList = new ArrayList<Account>();
        String sql = "SELECT * FROM account;";
        try {
            PreparedStatement ps = connect.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                accountList.add(new Account(rs.getInt("accountId"), rs.getInt("account"), rs.getInt("userId")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    public void update(Account account) {
        String sql = "UPDATE account SET account =" + account.getAccount() + ", userId =" + account.getUserId() + " WHERE accountId=" + account.getAccountId() + ";";
        try {
            PreparedStatement ps = connect.getConnection().prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Account account) {
        String sql = "DELETE FROM account WHERE accountId='" + account.getAccountId() + "';";
        try {
            PreparedStatement ps = connect.getConnection().prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}