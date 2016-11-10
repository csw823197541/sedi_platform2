package com.sedi.repository;

import com.sedi.entity.MailBoxEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by csw on 2016/11/4.
 */
public interface MailBoxRepository extends PagingAndSortingRepository<MailBoxEntity, Integer> {
}
