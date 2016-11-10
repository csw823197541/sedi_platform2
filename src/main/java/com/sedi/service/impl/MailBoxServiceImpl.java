package com.sedi.service.impl;

import com.sedi.entity.MailBoxEntity;
import com.sedi.exception.ObjectNotFoundException;
import com.sedi.repository.MailBoxRepository;
import com.sedi.service.MailBoxService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by csw on 2016/11/4.
 */
@Component("mailBoxService")
@Scope("prototype")
public class MailBoxServiceImpl extends BaseService implements MailBoxService {

    @Autowired
    private MailBoxRepository mailBoxRepository;

    public MailBoxEntity createMailBox(MailBoxEntity mailBoxEntity) {
        Validate.notNull(mailBoxEntity, "The mailBox must not be null, create failure.");
        MailBoxEntity created = mailBoxRepository.save(mailBoxEntity);
        return created;
    }

    @Transactional
    public MailBoxEntity updateMailBox(MailBoxEntity mailBoxEntity) {
        Validate.notNull(mailBoxEntity, "The mailBox must not be null, create failure.");
        Validate.notNull(mailBoxEntity.getId(), "The id of mailBox must not be null, create failure.");

        log.info(String.format("update Service receive mailBox'mailBoxId is: [%s]", mailBoxEntity.getId()));
        MailBoxEntity updated = mailBoxRepository.findOne(mailBoxEntity.getId());
        if (updated == null) {
            throw new ObjectNotFoundException("用户名不存在!");
        }
        updated = updated.changeInfoToUpdated(updated);
        MailBoxEntity saved = mailBoxRepository.save(updated);
        return saved;
    }

    @Transactional
    public MailBoxEntity deleteMailBox(Integer id) {
        Validate.notNull(id, "The id must not be null, create failure.");
        MailBoxEntity deleted = mailBoxRepository.findOne(id);
        if (deleted == null) {
            throw new ObjectNotFoundException("用户不存在!");
        }
        mailBoxRepository.delete(id);
        return deleted;
    }

    public List<MailBoxEntity> findAllMailBox() {
        return (List<MailBoxEntity>) mailBoxRepository.findAll();
    }
}
