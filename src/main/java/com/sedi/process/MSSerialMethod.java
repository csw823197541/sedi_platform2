package com.sedi.process;

import com.sedi.component.BaseComponent;

/**
 * Created by csw on 2016/11/29 16:33.
 * Explain:
 */
public class MSSerialMethod extends BaseComponent implements Runnable {

    private MSProcess msProcess;

    public MSSerialMethod(MSProcess msProcess) {
        this.msProcess = msProcess;
    }

    @Override
    public void run() {
        long st = System.currentTimeMillis();
        log.info("开始执行(serialMethod)方法");
        msProcess.execute();
        long en = System.currentTimeMillis();
        if (en - st < 1000) {
            try {
                Thread.currentThread().sleep(1000 - en + st);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("(serialMethod)方法执行结束");
    }
}
