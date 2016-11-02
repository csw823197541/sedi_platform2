package com.sedi.service.impl;

import com.sedi.entity.MessageEntity;
import com.sedi.repository.MessageRepository;
import com.sedi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by csw on 2016/11/2.
 */
@Component("MessageService")
@Scope("prototype")
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Transactional
    public MessageEntity createMessage(MessageEntity messageEntity){
    MessageEntity created = messageRepository.save(messageEntity);
        return created;
    }

    @Transactional
    public MessageEntity updateMessage(MessageEntity messageEntity){
    MessageEntity saved = messageRepository.save(messageEntity);
        return saved;
    }
    @Transactional
    public MessageEntity deleteMessage(Integer id){
        MessageEntity messageEntity = messageRepository.findOne(id);
        messageRepository.delete(id);
        return messageEntity;
    }

    public List<MessageEntity> findAllMessage(){return (List<MessageEntity>)messageRepository.findAll();}
}
