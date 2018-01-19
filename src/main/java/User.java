public class User {

    private int userId;
    private String name;
    private String surname;
    private Account account;

    public User() {}

    public User(int userId, String name, String surname){
        this.userId = userId;
        this.name = name;
        this.surname = surname;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Account getAccount(int accounts) {
        this.account.setUserId(userId);
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", account=" + account +
                '}';
    }
}
