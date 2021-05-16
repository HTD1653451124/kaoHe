package com.ccj.event.entity;

public class Admin {
    private int adminId;
    private String account;
    private String password;

    public Admin() {
    }

    public Admin(int adminId, String account, String password) {
        this.adminId = adminId;
        this.account = account;
        this.password = password;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
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
                "adminId=" + adminId +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
