package com.sedi.process;

import com.sedi.process.plugin.GetHGZLMT0102;
import com.sedi.process.plugin.SendCQMT9801;
import com.sedi.process.plugin.SendJCJGMT9901;

/**
 * Created by csw on 2016/11/17 16:27.
 * Explain:
 */
public class Test {

    public static void main(String[] args) {

        SendJCJGMT9901 sendJCJGMT9901 = new SendJCJGMT9901();
        GetHGZLMT0102 getHGZLMT0102 = new GetHGZLMT0102();
        SendCQMT9801 sendCQMT9801 = new SendCQMT9801();
        SendCQMT9801 sendCQMT98011 = new SendCQMT9801();
        SendCQMT9801 sendCQMT98012 = new SendCQMT9801();
        SendCQMT9801 sendCQMT98013 = new SendCQMT9801();

        MSManageSubject msManageSubject = MSManageSubject.getInstance();
        msManageSubject.addMSObserver(sendJCJGMT9901);
        msManageSubject.addMSObserver(getHGZLMT0102);
        msManageSubject.addMSObserver(sendCQMT9801);
        msManageSubject.addMSObserver(sendCQMT98011);
        msManageSubject.addMSObserver(sendCQMT98012);
        msManageSubject.addMSObserver(sendCQMT98013);
        msManageSubject.process();

    }

}
