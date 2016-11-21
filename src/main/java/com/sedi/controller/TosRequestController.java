package com.sedi.controller;

import com.sedi.entity.MessageEntity;
import com.sedi.model.ResultModel;
import com.sedi.service.MessageService;
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

    @RequestMapping(method = RequestMethod.GET)
    public ResultModel processTosRequest(@RequestParam String className,
                                         @RequestParam String msJsonStr) {
        ResultModel resultModel = new ResultModel(200, "接收到报文发送请求");

        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setCreateTime(new Date());

        messageService.createMessage(messageEntity);

        return resultModel;
    }
}
