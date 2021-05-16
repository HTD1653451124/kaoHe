package com.ccj.event.bean;

import com.ccj.event.entity.Types;

import java.util.List;
import java.util.Map;

public class AdminBean {
    //type放在这里
    private List<Types> types;
    //sum结果放这里
    private Map<Integer,Integer> result;

    public List<Types> getTypes() {
        return types;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }


    public Map<Integer, Integer> getResult() {
        return result;
    }

    public void setResult(Map<Integer, Integer> result) {
        this.result = result;
    }
}
