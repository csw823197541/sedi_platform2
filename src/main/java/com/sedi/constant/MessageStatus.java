package com.sedi.constant;

/**
 * Created by csw on 2016/11/4 14:46.
 * Explain: 报文状态
 */
public enum MessageStatus {

    //收到请求->生成报文成功/失败->发送成功/失败
    //收到报文->解析成功/失败->写入系统成功/部分成功/失败

    MS_RECEIVED("已收到"), MS_PARSE_FAILURE("解析失败"), MS_PARSED("已解析"), MS_SEND_FAILURE("发送失败"), MS_SENT("已发送");

    private String value;

    private MessageStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
