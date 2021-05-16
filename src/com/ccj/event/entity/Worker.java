package com.ccj.event.entity;

public class Worker {
    private int workerId;
    private String account;
    private String password;
    private String virName;
    private String gender;

    public Worker() {
    }


    public Worker(int workerId, String account, String password, String virName, String gender) {
        this.workerId = workerId;
        this.account = account;
        this.password = password;
        this.virName = virName;
        this.gender = gender;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
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
