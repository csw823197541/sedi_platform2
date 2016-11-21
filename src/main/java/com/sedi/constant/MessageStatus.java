package com.sedi.constant;

/**
 * Created by csw on 2016/11/4 14:46.
 * Explain: 报文状态
 */
public enum MessageStatus {

    //收到请求->生成报文成功/失败->发送成功/失败
    //收到报文->解析成功/失败->写入系统成功/部分成功/失败

    MS_RECEIVED("收到报文"),
    MS_GENERATE_FAILURE("生成报文失败"), MS_GENERATE_SUCCESS("生成报文成功"),
    MS_SEND_FAILURE("发送（FTP）失败"), MS_SEND_SUCCESS("发送（FTP）成功"),
    MS_WRITE_FAILURE("写入（TOS）失败"), MS_WRITE_SUCCESS("写入（TOS）成功"), MS_WRITE_PART_SUCCESS("部分写入系统成功");

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
