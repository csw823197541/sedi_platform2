package com.sedi.process.plugin

import com.sedi.process.MSObserver

/**
 * Created by csw on 2016/11/17 17:19.
 * Explain: 并行处理方法
 */
class ProcessMethodParallel {

    private List<MSObserver> msObserverList;

    private ProcessMethodParallel() {}

    private static class ProcessMethodFactory {
        private static ProcessMethodParallel instance = new ProcessMethodParallel();
    }

    public static ProcessMethodParallel getInstance() {
        return ProcessMethodFactory.instance;
    }

    void setMsObserverList(List<MSObserver> msObserverList) {
        this.msObserverList = msObserverList
    }

    public void processMS() {
        for (MSObserver msObserver : msObserverList) {
            msObserver.execute();
        }
    }
}
