package com.sedi.service.impl;

import com.sedi.entity.MessageEntity;
import com.sedi.entity.MessageTypeEntity;
import com.sedi.exception.ObjectNotFoundException;
import com.sedi.repository.MessageTypeRepository;
import com.sedi.service.MessageTypeService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by csw on 2016/11/4.
 */
@Component("messageTypeService")
@Scope("prototype")
public class MessageTypeServiceImpl extends BaseService implements MessageTypeService {
    @Autowired
    private MessageTypeRepository messageTypeRepository;

    public MessageTypeEntity createMessageType(MessageTypeEntity messageTypeEntity){
        Validate.notNull(messageTypeEntity, "The messageType must not be null, create failure.");
        MessageTypeEntity created = messageTypeRepository.save(messageTypeEntity);

        return created;
    }

    @Transactional
    public MessageTypeEntity updateMessageType(MessageTypeEntity messageTypeEntity){
        Validate.notNull(messageTypeEntity.getId(),"The id of messageType must not be null, create failure.");
        Validate.notNull(messageTypeEntity,"The messageType must not be null, create failure.");

        log.info(String.format("update Service receive messageType'messageTypeId is: [%s]", messageTypeEntity.getId()));
        MessageTypeEntity updated = messageTypeRepository.findOne(messageTypeEntity.getId());
        if (updated == null){
            throw new ObjectNotFoundException("用户不存在");
        }
        updated = updated.changeInfoToUpdated(updated);
        MessageTypeEntity saved = messageTypeRepository.save(updated);
        return saved;
    }

    @Transactional
    public MessageTypeEntity deleteMessageType(Integer id){
        Validate.notNull(id,"The id must not be null, create failure.");

        MessageTypeEntity deleted = messageTypeRepository.findOne(id);
        if (deleted == null){
            throw new ObjectNotFoundException("用户不存在");
        }
        messageTypeRepository.delete(id);

        return deleted;
    }
    public List<MessageTypeEntity> findAllMessageType(){return (List<MessageTypeEntity>)messageTypeRepository.findAll();}

}
