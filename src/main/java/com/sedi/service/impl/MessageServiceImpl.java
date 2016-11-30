package com.sedi.service.impl;

import com.sedi.entity.MessageEntity;
import com.sedi.entity.MessageTypeEntity;
import com.sedi.exception.ObjectNotFoundException;
import com.sedi.process.MSProcess;
import com.sedi.process.MSSerialMethod;
import com.sedi.process.MSThreadPool;
import com.sedi.process.plugin.SendJCJGMT9901;
import com.sedi.repository.MessageRepository;
import com.sedi.repository.MessageTypeRepository;
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

    @Autowired
    private MessageTypeRepository messageTypeRepository;

    public MessageEntity createMessage(MessageEntity messageEntity) {
        Validate.notNull(messageEntity, "The message must not be null, create failure.");

        MessageEntity created = messageRepository.save(messageEntity);

        if (created != null) {
            Validate.notNull(created.getMessageType(), "The messageType must not be null, do not execute the message.");
            MessageTypeEntity messageType = messageTypeRepository.findByType(created.getMessageType());
            if (messageType == null) {
                throw new ObjectNotFoundException("根据报文类型，数据库中没有找到相应报文类型记录！");
            }
            if ("".equals(messageType.getProcessMethod())) {

            }
            MSProcess sendJCJGMT9901 = new SendJCJGMT9901("我是SendJCJGMT9901报文处理方法,Id: " + created.getId());
            MSSerialMethod msSerialMethod = new MSSerialMethod(sendJCJGMT9901);
            MSThreadPool.singleThreadExecutor.execute(msSerialMethod);
        }

        return created;
    }

    @Transactional
    public MessageEntity updateMessage(MessageEntity messageEntity) {

        Validate.notNull(messageEntity.getId(), "The id of message must not be null, create failure.");
        Validate.notNull(messageEntity, "The message must not be null, create failure.");

        log.info(String.format("update service receive message'mssageId is: [%s]", messageEntity.getMessageId()));

        MessageEntity updated = messageRepository.findOne(messageEntity.getId());

        if (updated == null) {
            throw new ObjectNotFoundException("用户不存在");
        }

        updated = messageEntity.changeInfoToUpdated(updated);
//        updated = messageRepository.save(updated);
        return messageRepository.save(updated);
    }

    @Transactional
    public MessageEntity deleteMessage(Integer id) {
        Validate.notNull(id, "The id must not be null, delete failure.");

        MessageEntity deleted = messageRepository.findOne(id);
        if (deleted == null) {
            throw new ObjectNotFoundException("用户不存在");
        }

        messageRepository.delete(id);
        return deleted;
    }

    public List<MessageEntity> findAllMessage() {
        return (List<MessageEntity>) messageRepository.findAll();
    }

    public MessageEntity findOneMessage(Integer id) {
        Validate.notNull(id, "The id must not be null, find failure.");

        return messageRepository.findOne(id);
    }
}
