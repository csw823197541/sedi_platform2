package com.sedi.service.impl;

import com.sedi.entity.UserEntity;
import com.sedi.repository.UserRepository;
import com.sedi.service.UserService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by csw on 2016/11/1 10:15.
 * Explain:
 */
@Component("userService")
@Scope("prototype")
public class UserServiceImpl extends BaseService implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserEntity createUser(UserEntity userEntity) {
        Validate.notNull(userEntity, "The userName must not be null, find failure.");
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

    public UserEntity findOrgUser(String username, String password) {
        Validate.notNull(username, "The username must not be null.");
        Validate.notNull(password, "The password must not be null.");
        log.info(String.format("Receive login information by userName[%s], password[%s].", username, password));

        UserEntity userEntity = userRepository.findByUsernameAndPassword(username, password);

        return userEntity;
    }

    public UserEntity findByUsername(String s) {
        Validate.notNull(s, "The username must not be null.");

        return userRepository.findByUsername(s);
    }

}
