package com.sedi.service.impl;

import com.sedi.entity.MessageDetailEntity;
import com.sedi.entity.MessageEntity;
import com.sedi.exception.ObjectNotFoundException;
import com.sedi.repository.MessageDetailRepository;
import com.sedi.service.MessageDetailService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by csw on 2016/11/3.
 */
@Component("messageDetailService")
@Scope("prototype")
public class MessageDetailServiceImpl extends BaseService implements MessageDetailService {
    @Autowired
    private MessageDetailRepository messageDetailRepository;

    public MessageDetailEntity createMessageDetail(MessageDetailEntity messageDetailEntity) {

        Validate.notNull(messageDetailEntity, "The message must not be null, create failure.");

        MessageDetailEntity created = messageDetailRepository.save(messageDetailEntity);
        return created;
    }

    @Transactional
    public MessageDetailEntity updateMessageDetail(MessageDetailEntity messageDetailEntity) {

        Validate.notNull(messageDetailEntity.getId(), "The id of messageDetail must not be null, create failure.");
        Validate.notNull(messageDetailEntity, "The messageDetail must not be null, create failure.");

        log.info(String.format("update Service receive message'mssageDetailId is: [%s]", messageDetailEntity.getId()));

        MessageDetailEntity updated = messageDetailRepository.findOne(messageDetailEntity.getId());
        if (updated == null) {
            throw new ObjectNotFoundException("用户不存在");
        }

        updated = updated.changeInfoToUpdated(updated);
        MessageDetailEntity saved = messageDetailRepository.save(updated);

        return saved;
    }

    @Transactional
    public MessageDetailEntity deleteMessageDetail(Integer id) {
        Validate.notNull(id, "The id must not be null, create failure.");
        MessageDetailEntity deleted = messageDetailRepository.findOne(id);
        messageDetailRepository.delete(id);
        return deleted;
    }

    public List<MessageDetailEntity> findAllMessageDetail() {
        return (List<MessageDetailEntity>) messageDetailRepository.findAll();
    }
}
