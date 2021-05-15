package com.ccj.event.dao;

import com.ccj.event.entity.Article;
import com.ccj.event.entity.Worker;

public interface WorkerDao {
    /**
     * 注册服务工作者
     * @param worker
     * @return
     */
    public Boolean registerWorker(Worker worker);

    /**
     * 服务工作者登录
     * @param account
     * @param password
     * @return
     */
    public Boolean login(String account, String password);

    public Worker getWorkerInfo(String account);

    public Boolean publish(Article article);
}
