package com.ccj.event.dao;

import com.ccj.event.entity.Types;

import java.util.List;

public interface TypesDao {
    public List<Types> getAll();

    public void addTy(String text);
}
