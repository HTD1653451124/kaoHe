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

    /**
     * 通过账号获取服务工作者的信息
     * @param account
     * @return
     */
    public Worker getWorkerInfo(String account);

    /**
     * 发表文章
     * @param article
     * @return
     */
    public Boolean publish(Article article);
}
