package com.sedi.service;

import com.sedi.entity.UserEntity;

import java.util.List;

/**
 * Created by csw on 2016/11/1 10:16.
 * Explain:
 */
public interface UserService {
    UserEntity createUser(UserEntity userEntity);
    UserEntity updateUser(UserEntity user);
    UserEntity deleteUser(Integer id);

    List<UserEntity> findAllUser();

    UserEntity findById(Integer id);
}
