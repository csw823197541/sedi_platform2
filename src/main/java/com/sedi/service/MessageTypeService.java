package com.sedi.service;

import com.sedi.entity.MessageTypeEntity;

import java.util.List;

/**
 * Created by csw on 2016/11/4.
 */
public interface MessageTypeService {
    MessageTypeEntity createMessageType(MessageTypeEntity messageTypeEntity);

    MessageTypeEntity updateMessageType(MessageTypeEntity messageTypeEntity);

    MessageTypeEntity deleteMessageType(Integer id);

    List<MessageTypeEntity> findAllMessageType();
}
