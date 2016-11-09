package com.sedi.service;

import com.sedi.entity.MailBoxEntity;

import java.util.List;

/**
 * Created by csw on 2016/11/4.
 */
public interface MailBoxService {
    MailBoxEntity createMailBox(MailBoxEntity mailBoxEntity);
    MailBoxEntity updateMailBox(MailBoxEntity mailBoxEntity);
    MailBoxEntity deleteMailBox(Integer id);

    List<MailBoxEntity> findAllMailBox();


}
