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
    @Column(name = "re_content")
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

    public String getReContent() {
        return reContent;
    }

    public void setReContent(String reContent) {
        this.reContent = reContent;
    }

    public String getGeContent() {
        return geContent;
    }

    public void setGeContent(String geContent) {
        this.geContent = geContent;
    }

    public MessageDetailEntity changeInfoToUpdated(MessageDetailEntity updated) {

        if (updated != null) {
            updated.setReContent(this.reContent);
            updated.setGeContent(this.geContent);
            updated.setMessageEntity(this.messageEntity);
        }

        return updated;
    }
}
