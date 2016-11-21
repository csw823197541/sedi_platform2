package com.sedi.process.plugin

import com.sedi.constant.Utils;
import com.sedi.process.MSObserver;

/**
 * Created by csw on 2016/11/17 15:57.
 * Explain:
 */
public class SendJCJGMT9901 implements MSObserver{

    @Override
    public void execute() {
        System.out.println("执行SendJCJGMT9901报文, Id: " + Utils.sdfId.format(new Date()))
    }

    @Override
    String getProcessMethod() {
        return "serial"
    }
}
