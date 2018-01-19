import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcStart {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/user_bank_list";
    static final String USER = "root";
    static final String PASS = "root";

    static private Connection connection = null;
    static private Statement statement = null;
    static private ResultSet rs = null;

    public static User userCopy;

    public static void main(String[] args) {

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to a selected database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
            statement = connection.createStatement();
            // System.out.println(userCopy.toString());
            List users;
            users = getAllUsers();
            for (Object i: users
                 ) {
                System.out.println(i.toString());

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    connection.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static User getAllUserData(int userId) {
        User user = getUserData(userId);
        user = getAccountData(user);
        return user;
    }

    public static User getUserData(int userId) {
        User user = new User();
        String getData = "SELECT userId,name,surname FROM user WHERE userId =" + userId;
        try {
            rs = statement.executeQuery(getData);
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

    private static User getAccountData(User user) {
        Account account = new Account();
        int userId = user.getUserId();
        account.setUserId(userId);
        String getData = "SELECT accountId, account FROM account WHERE userId =" + userId;
        try {
            rs = statement.executeQuery(getData);
            while (rs.next()) {
                account.setAccountId(rs.getInt("accountId"));
                account.setAccount(rs.getInt("account"));
            }
            user.setAccount(account);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private static List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<User>();
        String getData = "SELECT userId FROM user";
        try {
            rs = statement.executeQuery(getData);
            while (rs.next()) {
                userCopy.setUserId(rs.getInt("userId"));
                getAllUserData(userCopy.getUserId());
                allUsers.add(userCopy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allUsers;
    }
}
