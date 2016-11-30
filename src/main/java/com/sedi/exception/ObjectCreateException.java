package com.sedi.exception;

import com.sedi.constant.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by csw on 2016/11/21 17:37.
 * Explain: 创建的对象保存到数据库中失败
 */
public class ObjectCreateException extends PlatformException {

    public ObjectCreateException(String msg) {
        super(HttpStatus.BAD_REQUEST, msg, ErrorCode.UNKNOWNERROR);
    }
}
