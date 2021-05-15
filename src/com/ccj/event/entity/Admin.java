package com.ccj.event.entity;

public class Admin {
    private int admin_id;
    private String account;
    private String password;

    public Admin() {
    }

    public Admin(int admin_id, String account, String password) {
        this.admin_id = admin_id;
        this.account = account;
        this.password = password;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
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

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
