package com.ccj.event.service.Impl;

import com.ccj.event.dao.Impl.TypesDaoImpl;
import com.ccj.event.entity.Types;
import com.ccj.event.service.TypesService;

import java.util.List;

public class TypesServiceImpl implements TypesService {
    @Override
    public List<Types> findAll() {
        TypesDaoImpl typesDao = new TypesDaoImpl();
        List<Types> all = typesDao.getAll();
        return all;
    }

    @Override
    public void addType(String text) {
        TypesDaoImpl typesDao = new TypesDaoImpl();
        typesDao.addTy(text);
    }
}
