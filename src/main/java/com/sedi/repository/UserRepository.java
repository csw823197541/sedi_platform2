package com.sedi.repository;

import com.sedi.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by csw on 2016/11/1 10:14.
 * Explain:
 */
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Integer> {

}
