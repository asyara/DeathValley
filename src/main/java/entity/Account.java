package entity;

public class Account {

    private int accountId;
    private int account;
    private int userId;

    public Account() {}

    public Account(int accountId, int account, int userId) {
        this.accountId = accountId;
        this.account = account;
        this.userId = userId;
    }

    public Account(int account, int userId) {
        this.account = account;
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account1 = (Account) o;

        if (accountId != account1.accountId) return false;
        if (account != account1.account) return false;
        return userId == account1.userId;
    }

    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + account;
        result = 31 * result + userId;
        return result;
    }

    @Override
    public String toString() {
        return "entity.Account{" +
                "accountId=" + accountId +
                ", account=" + account +
                ", userId=" + userId +
                '}';
    }
}
