package com.ccj.event.service.Impl;

import com.ccj.event.bean.AdminBean;
import com.ccj.event.dao.Impl.AdminDaoImpl;
import com.ccj.event.dao.Impl.ArticleDaoImpl;
import com.ccj.event.entity.Types;
import com.ccj.event.service.AdminService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AdminServiceImpl implements AdminService {
    @Override
    public AdminBean getInfo() {
        AdminDaoImpl adminDao = new AdminDaoImpl();
        List<Types> types = adminDao.getTypes();
        List<Integer> count = adminDao.getCount(types);
        AdminBean adminBean = new AdminBean();
        adminBean.setTypes(types);
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < types.size(); i++) {
            //key存放typesId,value存放计算出来的和
            map.put(types.get(i).getTypesId(),count.get(i));
        }
        adminBean.setResult(map);
        return  adminBean;

    }

    @Override
    public void deleteTypes(String typesId) {
        AdminDaoImpl adminDao = new AdminDaoImpl();
        adminDao.delete(typesId);
    }
}
