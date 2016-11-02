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

}
