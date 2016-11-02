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

    @Column(name = "type")
    private String type;//报文类型

    @Column(name = "message_id")
    private String messageId;//报文ID

    @Column(name = "unit_Id")
    private String unitId;//

    @Column(name = "vessel_VisitId")
    private String vesselVisitId;//

    @Column(name = "status")
    private String status;//报文发送、接收状态

    @Column(name = "reason")
    private String reason;//状态原因

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "send_Time")
    private Date sendTime;//发送日期

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_Time")
    private Date createTime;//创建日期

    @Column(name = "note")
    private String note;//备注

    @OneToOne(fetch = FetchType.EAGER)
    private MessageDetailEntity messageDetailEntity;

    //报文内容参考MessageDetailEntity


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

    public MessageDetailEntity getMessageDetailEntity() {
        return messageDetailEntity;
    }

    public void setMessageDetailEntity(MessageDetailEntity messageDetailEntity) {
        this.messageDetailEntity = messageDetailEntity;
    }
}
