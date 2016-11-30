package com.sedi.process.plugin

import com.sedi.constant.Utils
import com.sedi.process.MSProcess

/**
 * Created by csw on 2016/11/17 16:35.
 * Explain: 
 */
class SendCQMT9801 implements MSProcess{

    private String processName;

    public SendCQMT9801(String processName) {
        this.processName = processName;
    }

    @Override
    public void execute() {
        System.out.println("执行SendCQMT9801报文, Id: " + Utils.sdfId.format(new Date()))
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
