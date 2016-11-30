package com.sedi.controller;

import com.sedi.entity.MessageDetailEntity;
import com.sedi.entity.MessageEntity;
import com.sedi.exception.ObjectCreateException;
import com.sedi.model.ResultModel;
import com.sedi.service.MessageDetailService;
import com.sedi.service.MessageService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by csw on 2016/11/21 16:15.
 * Explain: 接收Tos请求的接口,接收报文发送请求
 */
@RestController
@RequestMapping("api/tosRequests")
public class TosRequestController extends BaseController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageDetailService messageDetailService;

    @RequestMapping(method = RequestMethod.POST)
    public ResultModel processTosRequest(@RequestParam String messageType,
                                         @RequestParam String msJsonStr) {
        Validate.notNull(messageType, "The messageType must not be null.");
        Validate.notNull(msJsonStr, "The msJsonStr(message content) must not be null");
        log.info(String.format("TosRequestController received messageType is: [%s]", messageType));
        log.info(String.format("TosRequestController received message json Str is: [%s]", msJsonStr));

        ResultModel resultModel = new ResultModel(200, "接收到报文发送请求");

        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setCreateTime(new Date());
        messageEntity.setMessageType(messageType);
        messageEntity.setMessageId(new Date().toString());

        //先保存接收到的报文详情内容
        MessageDetailEntity messageDetailEntity = new MessageDetailEntity();
        messageDetailEntity.setReContent(msJsonStr);
        messageDetailEntity = messageDetailService.createMessageDetail(messageDetailEntity);

        if (messageDetailEntity.getId() == null) {
            throw new  ObjectCreateException("创建报文详细内容失败，请仔细检查发送的报文内容");
        }

        messageEntity.setMessageDetailId(messageDetailEntity.getId());
        messageService.createMessage(messageEntity);

        return resultModel;
    }
}
