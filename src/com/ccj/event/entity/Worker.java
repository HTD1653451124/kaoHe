package com.ccj.event.entity;

public class Worker {
    private int worker_id;
    private String account;
    private String password;
    private String virName;
    private String gender;

    public Worker() {
    }

    public Worker(int worker_id, String account, String password, String virName, String gender) {
        this.worker_id = worker_id;
        this.account = account;
        this.password = password;
        this.virName = virName;
        this.gender = gender;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
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
        return "Worker{" +
                "worker_id=" + worker_id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", virName='" + virName + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
