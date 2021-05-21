package com.ccj.event.dao;

import com.ccj.event.entity.Types;

import java.util.List;

public interface AdminDao {
    /**
     * 获取所有文章种类
     * @return
     */
    public List<Types> getTypes();

    /**
     * 获取不同类别的浏览量
     * @param list
     * @return
     */
    public List<Integer> getCount(List<Types> list);

    /**
     * 删除文章种类，删除该种类的所有文章
     * @param typeId
     */
    public void delete (String typeId);

}
