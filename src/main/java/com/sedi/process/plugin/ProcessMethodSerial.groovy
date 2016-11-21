package com.sedi.process.plugin

import com.sedi.process.MSObserver

/**
 * Created by csw on 2016/11/17 17:18.
 * Explain: 串行处理方法, 单列模式
 */
class ProcessMethodSerial {

    private List<MSObserver> msObserverList;

    private ProcessMethodSerial() {

    }

    private static class ProcessMethodFactory {
        private static ProcessMethodSerial instance = new ProcessMethodSerial();
    }

    public static ProcessMethodSerial getInstance() {
        return ProcessMethodFactory.instance;
    }

    void setMsObserverList(List<MSObserver> msObserverList) {
        this.msObserverList = msObserverList
    }

    public void processMS() {
        for (MSObserver msObserver : msObserverList) {
            msObserver.execute();
            sleep(1000);
        }
    }
}
