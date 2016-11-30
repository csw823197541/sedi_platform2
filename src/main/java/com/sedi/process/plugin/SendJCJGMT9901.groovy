package com.sedi.process.plugin

import com.sedi.constant.Utils;
import com.sedi.process.MSProcess;

/**
 * Created by csw on 2016/11/17 15:57.
 * Explain:
 */
public class SendJCJGMT9901 implements MSProcess{

    private String processName;

    public SendJCJGMT9901(String processName) {
        this.processName = processName;
    }

    @Override
    public void execute() {
        System.out.println("执行SendJCJGMT9901报文, 时间: " + Utils.sdfId.format(new Date()))
    }

    @Override
    String getProcessMethod() {
        return "serial"
    }

    @Override
    String toString() {
        return processName
    }
}
