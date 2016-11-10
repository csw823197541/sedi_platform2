package com.sedi.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by csw on 2016/11/2 9:42.
 * Explain:
 */
@Entity
@Table(name = "message")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;//key

    @Column(name = "message_type")
    private String messageType;//报文类型

    @Column(name = "message_id", nullable = false)
    private String messageId;//报文ID

    @Column(name = "unit_Id")
    private String unitId;//箱号

    @Column(name = "vessel_visitId")
    private String vesselVisitId;//航次

    @Column(name = "bill_No")
    private String billNo;//提单号

    @Column(name = "key1")
    private String key1;//查询条件1

    @Column(name = "key2")
    private String key2;

    @Column(name = "key3")
    private String key3;

    @Column(name = "manual")
    private String manual;//是否手工处理

    @Column(name = "status")
    private String status;//报文发送、接收状态

    @Column(name = "reason")
    private String reason;//状态原因

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "send_time")
    private Date sendTime;//发送日期

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    private Date createTime;//创建日期

    @Column(name = "note")
    private String note;//备注

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "message_detail")
    private MessageDetailEntity messageDetail;

    //报文内容参考MessageDetailEntity


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    public String getManual() {
        return manual;
    }

    public void setManual(String manual) {
        this.manual = manual;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getVesselVisitId() {
        return vesselVisitId;
    }

    public void setVesselVisitId(String vesselVisitId) {
        this.vesselVisitId = vesselVisitId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public MessageDetailEntity getMessageDetail() {
        return messageDetail;
    }

    public void setMessageDetail(MessageDetailEntity messageDetail) {
        this.messageDetail = messageDetail;
    }

    public MessageEntity changeInfoToUpdated(MessageEntity updated) {

        if (updated != null) {
            updated.setBillNo(this.billNo);
            updated.setKey1(this.key1);
            updated.setKey2(this.key2);
            updated.setKey3(this.key3);
            updated.setCreateTime(this.createTime);
            updated.setManual(this.manual);
            updated.setMessageId(this.messageId);
            updated.setMessageType(this.messageType);
            updated.setSendTime(this.sendTime);
            updated.setMessageDetail(this.messageDetail);
            updated.setNote(this.note);
            updated.setReason(this.reason);
            updated.setStatus(this.status);
            updated.setUnitId(this.unitId);
            updated.setVesselVisitId(this.vesselVisitId);
        }

        return updated;
    }
}
