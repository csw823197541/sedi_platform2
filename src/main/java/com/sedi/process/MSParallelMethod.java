package com.sedi.process;

import com.sedi.component.BaseComponent;


/**
 * Created by csw on 2016/11/29 17:38.
 * Explain:
 */
public class MSParallelMethod extends BaseComponent implements Runnable {

    private MSProcess msProcess;

    public MSParallelMethod(MSProcess msProcess) {
        this.msProcess = msProcess;
    }

    @Override
    public void run() {
        log.info("开始执行(parallelMethod)方法");
        msProcess.execute();
        log.info("(parallelMethod)方法执行结束");
    }
}
