package com.ccj.event.dao;

import com.ccj.event.entity.Types;

import java.util.List;

public interface AdminDao {
    public List<Types> getTypes();
    public List<Integer> getCount(List<Types> list);
    public void delete (String typeId);

}
