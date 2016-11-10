package com.sedi.service;

import com.sedi.entity.MessageEntity;

import java.util.List;

/**
 * Created by csw on 2016/11/2.
 */
public interface MessageService {

    MessageEntity createMessage(MessageEntity messageEntity);

    MessageEntity updateMessage(MessageEntity messageEntity);

    MessageEntity deleteMessage(Integer id);

    List<MessageEntity> findAllMessage();
}
