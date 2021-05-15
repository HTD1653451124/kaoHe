package com.ccj.event.service.Impl;

import com.ccj.event.dao.Impl.UserDaoImpl;
import com.ccj.event.entity.User;
import com.ccj.event.service.UserService;

public class UserServiceImpl implements UserService {

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        //先查询是否账号重复
        UserDaoImpl userDao = new UserDaoImpl();
        Boolean isExist = userDao.checkUser(user.getAccount(),true);
        if (isExist){
            //存在
            return false;//存在则不能注册，返回false
        }else {
            //不存在，将数据存到数据库
            userDao.registUser(user);
            return true;
        }
    }

    public Boolean login(String account, String password) {
        UserDaoImpl userDao = new UserDaoImpl();
        Boolean isSuccess = userDao.login(account, password);
        return  isSuccess;
    }

    /**
     * 根据账号获取user的所有信息
     * @param account
     * @return
     */
    @Override
    public User findAll(String account) {
        UserDaoImpl userDao = new UserDaoImpl();
        User all = userDao.getAll(account);
        return all;
    }
}
