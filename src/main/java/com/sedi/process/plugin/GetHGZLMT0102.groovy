package com.sedi.process.plugin

import com.sedi.constant.Utils;
import com.sedi.process.MSObserver;

/**
 * Created by csw on 2016/11/17 15:59.
 * Explain:
 */
public class GetHGZLMT0102 implements MSObserver {

    @Override
    public void execute() {
        System.out.println("执行GetHGZLMT0102报文, Id: " + Utils.sdfId.format(new Date()))
    }

    @Override
    String getProcessMethod() {
        return "parallel"
    }
}
