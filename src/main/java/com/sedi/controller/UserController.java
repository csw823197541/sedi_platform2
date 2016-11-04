package com.sedi.controller;

import com.sedi.component.BaseComponent;
import com.sedi.entity.UserEntity;
import com.sedi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by csw on 2016/11/1 10:14.
 * Explain:
 */
@RestController
@RequestMapping("api/users")
public class UserController extends BaseComponent{

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<UserEntity> getAll() {

        return userService.findAllUser();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserEntity findOne(@PathVariable Integer id) {

        log.info(String.format("Receive user's id is: [%d]", id));

        return userService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity create(@RequestBody(required = true) UserEntity userEntity) {
        UserEntity created = userService.createUser(userEntity);
        return created;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public UserEntity update(@PathVariable Integer id,
                             @RequestParam String userName,
                             @RequestParam String password) {
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setPassword(password);
        user.setUserName(userName);
        UserEntity updated = userService.updateUser(user);
        return updated;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public UserEntity delete(@PathVariable Integer id) {

        return userService.deleteUser(id);
    }
}
