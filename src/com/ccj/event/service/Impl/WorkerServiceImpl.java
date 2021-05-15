package com.ccj.event.service.Impl;

import com.ccj.event.dao.Impl.UserDaoImpl;
import com.ccj.event.dao.Impl.WorkerDaoImpl;
import com.ccj.event.entity.Article;
import com.ccj.event.entity.Worker;
import com.ccj.event.service.WorkerService;

public class WorkerServiceImpl implements WorkerService {
    /**
     * 注册worker
     * @param worker
     * @return
     */
    @Override
    public Boolean regis(Worker worker) {
        //先查询是否账号重复
        UserDaoImpl userDao = new UserDaoImpl();
        Boolean isExist = userDao.checkUser(worker.getAccount(),false);
        WorkerDaoImpl workerDao = new WorkerDaoImpl();
        if (isExist){
            //存在
            return false;//存在则不能注册，返回false
        }else {
            //不存在，将数据存到数据库
            workerDao.registerWorker(worker);
            return true;
        }

    }

    /**
     * worker登录
     * @param account
     * @param password
     * @return
     */
    @Override
    public Boolean login(String account, String password) {
        WorkerDaoImpl workerDao = new WorkerDaoImpl();
        Boolean login = workerDao.login(account, password);
        return login;
    }

    /**
     * 获取worker的信息
     * @param account
     * @return
     */
    @Override
    public Worker getWorkerMsg(String account) {
        WorkerDaoImpl workerDao = new WorkerDaoImpl();
        Worker workerInfo = workerDao.getWorkerInfo(account);
        return workerInfo;
    }

    /**
     * 发布文章
     * @param article
     * @return
     */
    @Override
    public Boolean publish(Article article) {
        WorkerDaoImpl workerDao = new WorkerDaoImpl();
        Boolean publish = workerDao.publish(article);
        return publish;
    }
}
