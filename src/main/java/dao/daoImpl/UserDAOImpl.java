package dao.daoImpl;

import service.DBconnect;
import dao.UserDAOInterface;
import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImpl implements UserDAOInterface {

    DBconnect connect;

    public UserDAOImpl(){
        this.connect = new DBconnect();
    }

    public void create(User user) {
        String sql = "INSERT INTO user(name,surname) VALUES('" + user.getName() + "','" + user.getSurname() + "');";
        try {
            PreparedStatement ps = connect.getConnection().prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getById(int id) {
        User user = new User();
        String sql = "SELECT * FROM user WHERE userId=" + id + ";";
        try {
            PreparedStatement ps = connect.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setUserId(rs.getInt("userId"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void update(User user) {
        String sql = "UPDATE user SET name ='" + user.getName() + "', surname ='" + user.getSurname() + "' WHERE userId=" + user.getUserId() + ";";
        try {
            PreparedStatement ps = connect.getConnection().prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(User user) {
        String sql = "DELETE FROM user WHERE userId='" + user.getUserId() + "';";
        try {
            PreparedStatement ps = connect.getConnection().prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getRichestUser() {
        User user = new User();
        String sql = "SELECT * FROM user WHERE userId in (SELECT userId FROM account GROUP BY userId having sum(account) >= ALL (SELECT sum(account) FROM account GROUP BY userId));";
        try {
            PreparedStatement ps = connect.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt(1);
                user = getById(userId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

