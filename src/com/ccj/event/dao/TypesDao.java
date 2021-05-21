package com.ccj.event.dao;

import com.ccj.event.entity.Types;

import java.util.List;

public interface TypesDao {
    /**
     * 获取所有文章的种类
     * @return
     */
    public List<Types> getAll();

    /**
     * 添加一个种类
     * @param text
     */
    public void addTy(String text);
}
