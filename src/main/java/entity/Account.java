package entity;

import javax.persistence.*;

/**
 * Created by DmitryL on 24.01.2018.
 */
@Entity
@Table(name = "account", schema = "user_bank_list")
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "accountId", nullable = false, updatable = false)
    private int accountId;

    @Column(name = "account")
    private int account;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public Account() {}

    public Account(int account, User user) {
        this.account = account;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", account=" + account +
                ", user=" + user +
                '}';
    }
}
