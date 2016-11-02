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

    @Column(name = "content")
    private String content;//报文内容

    @OneToOne(fetch = FetchType.EAGER , mappedBy = "message")
    @JoinColumn(name = "message_Entity" )
    private MessageEntity messageEntity;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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
