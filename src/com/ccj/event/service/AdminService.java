package com.ccj.event.service;

import com.ccj.event.bean.AdminBean;

public interface AdminService {
    public AdminBean getInfo();
    public void deleteTypes(String typesId);
}
