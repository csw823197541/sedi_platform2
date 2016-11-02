package com.sedi.entity;

import java.util.Date;

/**
 * Created by csw on 2016/11/2 9:42.
 * Explain:
 */
public class MessageEntity {

    private Integer id;//key
    private String type;//报文类型
    private String messageId;//报文ID
    private String unitId;//
    private String vesselVisitId;//
    private String status;//报文发送、接收状态
    private String reason;//状态原因
    private Date sendTime;//发送日期
    private Date createTime;//创建日期
    private String note;//备注

    //报文内容参考MessageDetailEntity
}
