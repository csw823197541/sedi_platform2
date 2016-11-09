package com.sedi.service;

import com.sedi.entity.MessageDetailEntity;

import java.util.List;

/**
 * Created by csw on 2016/11/3.
 */
public interface MessageDetailService {
    MessageDetailEntity createMessageDetail(MessageDetailEntity messageDetailEntity);
    MessageDetailEntity updateMessageDetail(MessageDetailEntity messageDetailEntity);
    MessageDetailEntity deleteMessageDetail(Integer id);

    List<MessageDetailEntity> findAllMessageDetail();
}
