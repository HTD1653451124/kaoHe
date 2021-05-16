package com.ccj.event.entity;

public class User {
    private int userId;
    private String account;
    private String password;
    private String virName;
    private String gender;

    public User() {
    }

    public User(int userId, String account, String password, String virName, String gender) {
        this.userId = userId;
        this.account = account;
        this.password = password;
        this.virName = virName;
        this.gender = gender;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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


}
