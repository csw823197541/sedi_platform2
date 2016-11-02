package com.sedi.controller;

import com.sedi.entity.MessageEntity;
import com.sedi.entity.UserEntity;
import com.sedi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by csw on 2016/11/2.
 */
@RestController
@RequestMapping("api/ Messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.GET)
    public List<MessageEntity> getAll() {

        return messageService.findAllMessage();
    }
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MessageEntity create(@RequestBody(required = true) MessageEntity messageEntity){
        MessageEntity created = messageService.createMessage(messageEntity);
        return created;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public MessageEntity update(@PathVariable Integer id,
                                @RequestBody MessageEntity messageEntity){

        messageEntity.setId(id);
        MessageEntity updated = messageService.updateMessage(messageEntity);
        return updated;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public MessageEntity delete(@PathVariable Integer id){
        return messageService.deleteMessage(id);
    }
}
