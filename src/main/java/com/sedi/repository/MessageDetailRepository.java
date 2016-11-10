package com.sedi.repository;

import com.sedi.entity.MessageDetailEntity;
import com.sedi.entity.MessageEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by csw on 2016/11/3.
 */
public interface MessageDetailRepository extends PagingAndSortingRepository<MessageDetailEntity, Integer> {
}
