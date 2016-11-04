package com.sedi.exception;

import com.sedi.constant.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by csw on 2016/11/04 19:34.
 * explain：客户端输入信息，验证发生异常
 */
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "验证错误，无法通过")
public class InvalidOperatorException extends PlatformException {

    public InvalidOperatorException(String message) {
        super(HttpStatus.BAD_REQUEST, message, ErrorCode.INVAILDOPERATOR);
    }
}
