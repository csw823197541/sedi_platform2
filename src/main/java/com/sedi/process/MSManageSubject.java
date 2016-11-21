package com.sedi.process;

/**
 * Created by csw on 2016/11/17 16:25.
 * Explain: 单列模式的类，统一处理报文队列
 */
public class MSManageSubject extends MSAbstractSubject {

    private MSManageSubject() {}

    private static class MSSubjectFactory {
        private static MSManageSubject instance = new MSManageSubject();
    }

    public static MSManageSubject getInstance() {
        return MSSubjectFactory.instance;
    }

    public void process() {
        System.out.println("开始处理报文");
        notifyMSObserver();
        System.out.println("结束");
    }
}
