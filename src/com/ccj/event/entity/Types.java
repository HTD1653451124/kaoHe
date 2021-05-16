package com.ccj.event.entity;

public class Types {
    private int typesId;
    private String type;

    public Types() {
    }


    public int getTypesId() {
        return typesId;
    }

    public void setTypesId(int typesId) {
        this.typesId = typesId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public Types(int typesId, String type) {
        this.typesId = typesId;
        this.type = type;
    }
}
