package com.sedi.exception;

import com.sedi.constant.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by csw on 2016/11/04 9:24.
 * explain：数据库中查找不到对象
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "所查找的对象不存在")
public class ObjectNotFoundException extends PlatformException {

    public ObjectNotFoundException(String message) {

        super(HttpStatus.NOT_FOUND, message, ErrorCode.USERNOTFOUND);
    }
}
