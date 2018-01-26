package entity;

import javax.persistence.*;

/**
 * Created by DmitryL on 24.01.2018.
 */
@Entity
@Table(name = "user", schema = "user_bank_list")
public class User {
    private int userId;
    private String name;
    private String sureName;

    @Id
    @GeneratedValue
    @Column(name = "userId", nullable = false, updatable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "name", length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sureName", length = 45)
    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", sureName='" + sureName + '\'' +
                '}';
    }
}
