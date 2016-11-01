package com.sedi.controller;

import com.sedi.entity.UserEntity;
import com.sedi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by csw on 2016/11/1 10:14.
 * Explain:
 */
@RestController
@RequestMapping("api/ Users")
public class UserController {
    @Autowired
    private UserService userService;

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
