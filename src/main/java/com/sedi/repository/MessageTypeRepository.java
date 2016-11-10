package com.sedi.repository;

import com.sedi.entity.MessageTypeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by csw on 2016/11/4.
 */
public interface MessageTypeRepository extends PagingAndSortingRepository<MessageTypeEntity, Integer> {
}
