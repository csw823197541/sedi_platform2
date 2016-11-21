package com.sedi.process;

/**
 * Created by csw on 2016/11/17 15:50.
 * Explain:
 */
public interface MSSubject {

    void addMSObserver(MSObserver msObserver);

    void removeMSObserver(MSObserver msObserver);

    void notifyMSObserver();
}
