package com.sedi.service.impl;

import com.sedi.entity.UserEntity;
import com.sedi.repository.UserRepository;
import com.sedi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by csw on 2016/11/1 10:15.
 * Explain:
 */
@Component("UserService")
@Scope("prototype")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Transactional
    public UserEntity createUser(UserEntity userEntity) {
//        Validate.notNull(userEntity, "The userName must not be null, find failure.");
        UserEntity created = userRepository.save(userEntity);
        return created;

    }

    @Transactional
    public UserEntity updateUser(UserEntity user) {
        UserEntity saved = userRepository.save(user);
        return saved;
    }

    @Transactional
    public UserEntity deleteUser(Integer id) {
        UserEntity userEntity = userRepository.findOne(id);
        userRepository.delete(id);
        return userEntity;
    }

    public List<UserEntity> findAllUser() {
        return (List<UserEntity>) userRepository.findAll();
    }

    public UserEntity findById(Integer id) {
        return userRepository.findOne(id);
    }

}
