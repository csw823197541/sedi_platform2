package com.sedi.entity;

import javax.persistence.*;

/**
 * Created by csw on 2016/11/2 9:46.
 * Explain:
 */
@Entity
@Table(name = "message_detail")
public class MessageDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;//key

    private String reContent;//接收到的报文内容

    @Column(name = "ge_content")
    private String geContent;//生成的报文内容

    @OneToOne(mappedBy = "messageDetailEntity")
    private MessageEntity messageEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MessageEntity getMessageEntity() {
        return messageEntity;
    }

    public void setMessageEntity(MessageEntity messageEntity) {
        this.messageEntity = messageEntity;
    }
}
