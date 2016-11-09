package com.sedi.service.impl;

import com.sedi.entity.MessageEntity;
import com.sedi.exception.ObjectNotFoundException;
import com.sedi.repository.MessageRepository;
import com.sedi.service.MessageService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by csw on 2016/11/2.
 */
@Component("messageService")
@Scope("prototype")
public class MessageServiceImpl extends BaseService implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public MessageEntity createMessage(MessageEntity messageEntity){

        Validate.notNull(messageEntity, "The message must not be null, create failure.");

        MessageEntity created = messageRepository.save(messageEntity);
        return created;
    }

    @Transactional
    public MessageEntity updateMessage(MessageEntity messageEntity){

        Validate.notNull(messageEntity.getId(), "The id of message must not be null, create failure.");
        Validate.notNull(messageEntity, "The message must not be null, create failure.");

        log.info(String.format("update Service receive message'mssageId is: [%s]", messageEntity.getMessageId()));

        MessageEntity updated = messageRepository.findOne(messageEntity.getId());
        if (updated == null){
            throw new ObjectNotFoundException("用户不存在");
        }

        updated = updated.changeInfoToUpdated(updated);
        MessageEntity saved = messageRepository.save(updated);
        return saved;
    }

    @Transactional
    public MessageEntity deleteMessage(Integer id){
        Validate.notNull(id, "The id must not be null, create failure.");

         MessageEntity deleted = messageRepository.findOne(id);
        if(deleted == null) {
            throw new ObjectNotFoundException("用户不存在");
        }

        messageRepository.delete(id);
        return deleted;
    }

    public List<MessageEntity> findAllMessage(){return (List<MessageEntity>)messageRepository.findAll();}
}
