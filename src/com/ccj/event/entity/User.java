package com.ccj.event.entity;

public class User {
    private int user_id;
    private String account;
    private String password;
    private String virName;
    private String gender;

    public User() {
    }

    public User(int user_id, String account, String password, String virName, String gender) {
        this.user_id = user_id;
        this.account = account;
        this.password = password;
        this.virName = virName;
        this.gender = gender;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVirName() {
        return virName;
    }

    public void setVirName(String virName) {
        this.virName = virName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", virName='" + virName + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
