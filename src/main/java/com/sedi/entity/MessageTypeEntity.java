package com.sedi.entity;

/**
 * Created by csw on 2016/11/2 9:54.
 * Explain:
 */
public class MessageTypeEntity {

    private Integer id;//key
    private String type;//报文类型
    private String direction;//接收receive、发送send
    private String className;//处理该报文对应的groovy插件类名
    private String note;//备注

    public MessageTypeEntity(String type, String direction, String className, String note) {
        this.type = type;
        this.direction = direction;
        this.className = className;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
