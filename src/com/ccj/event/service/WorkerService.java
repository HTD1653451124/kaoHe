package com.ccj.event.service;

import com.ccj.event.entity.Article;
import com.ccj.event.entity.Worker;

public interface WorkerService {
    /**
     * 注册worker
     * @param worker
     * @return
     */
    public Boolean regis(Worker worker);

    /**
     * worker登录
     * @param account
     * @param password
     * @return
     */
    public Boolean login(String account,String password);

    public Worker getWorkerMsg(String account);

    public Boolean publish(Article article);
}
