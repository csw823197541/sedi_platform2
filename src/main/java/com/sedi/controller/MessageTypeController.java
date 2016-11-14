package com.sedi.controller;

import com.sedi.entity.CodeMapEntity;
import com.sedi.entity.MessageEntity;
import com.sedi.entity.MessageTypeEntity;
import com.sedi.service.MessageTypeService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

/**
 * Created by csw on 2016/11/10 10:01.
 * Explain:
 */
@RestController
@RequestMapping("api/messageTypes")
public class MessageTypeController extends BaseController {

    @Autowired
    private MessageTypeService messageTypeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<MessageTypeEntity> getAll() {

        return messageTypeService.findAllMessageType();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MessageTypeEntity create(@RequestBody(required = true) MessageTypeEntity messageTypeEntity) {
        Validate.notNull(messageTypeEntity, "The messageTypeEntity must not be null, create failure.");

        log.info(String.format("Controller receive messageTypeEntity'type is: [%s]", messageTypeEntity.getType()));

        MessageTypeEntity created = messageTypeService.createMessageType(messageTypeEntity);
        return created;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public MessageTypeEntity update(@PathVariable Integer id,
                                    @RequestBody MessageTypeEntity messageTypeEntity) {
        Validate.notNull(messageTypeEntity, "The messageTypeEntity must not be null, update failure.");
        Validate.notNull(id, "The id of messageTypeEntity must not be null, update failure.");

        log.info(String.format("Controller receive messageTypeEntity'id is: [%d], messageType is: [%s]", messageTypeEntity.getId(), messageTypeEntity.getType()));

        messageTypeEntity.setId(id);
        MessageTypeEntity updated = messageTypeService.updateMessageType(messageTypeEntity);

        return updated;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public MessageTypeEntity delete(@PathVariable Integer id) {
        Validate.notNull(id, "The id of messageTypeEntity must not be null, delete failure.");

        return messageTypeService.deleteMessageType(id);
    }
}
