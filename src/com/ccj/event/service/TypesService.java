package com.ccj.event.service;

import com.ccj.event.entity.Types;

import java.util.List;

public interface TypesService {
    public List<Types> findAll();
    public void addType(String text);
}
