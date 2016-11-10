package com.sedi.repository;

import com.sedi.entity.MessageEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by csw on 2016/11/2.
 */
public interface MessageRepository
        extends PagingAndSortingRepository<MessageEntity, Integer> {

}
