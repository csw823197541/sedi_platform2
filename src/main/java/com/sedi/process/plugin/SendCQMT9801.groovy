package com.sedi.process.plugin

import com.sedi.constant.Utils
import com.sedi.process.MSObserver

/**
 * Created by csw on 2016/11/17 16:35.
 * Explain: 
 */
class SendCQMT9801 implements MSObserver{

    @Override
    public void execute() {
        System.out.println("执行SendCQMT9801报文, Id: " + Utils.sdfId.format(new Date()))
    }

    @Override
    String getProcessMethod() {
        return "serial"
    }

}
