package com.sedi.process;

import com.sedi.process.plugin.ProcessMethodParallel;
import com.sedi.process.plugin.ProcessMethodSerial;

import java.util.*;

/**
 * Created by csw on 2016/11/17 16:03.
 * Explain: 抽象主题（其实被继承后，也是个单例模式）
 * 添加/去除不同报文处理方法的观察者，根据方法处理队列中的报文（MSObserver对象）
 */
public abstract class MSAbstractSubject implements MSSubject{

    //<处理方法,Set>，有多种方法处理MSObserver,相同处理方法的报文放在同一个队列里
    private Map<String, List<MSObserver>> methodObserverMap = new HashMap<>();

    @Override
    public void addMSObserver(MSObserver msObserver) {
        if (methodObserverMap.get(msObserver.getProcessMethod()) != null) {
            methodObserverMap.get(msObserver.getProcessMethod()).add(msObserver);
        } else {
            List<MSObserver> msObservers = new ArrayList<>();
            msObservers.add(msObserver);
            methodObserverMap.put(msObserver.getProcessMethod(), msObservers);
        }
    }

    @Override
    public void removeMSObserver(MSObserver msObserver) {
        if (methodObserverMap.get(msObserver.getProcessMethod()) != null) {
            methodObserverMap.get(msObserver.getProcessMethod()).remove(msObserver);
        }
    }

    @Override
    public void notifyMSObserver() {

        Set<String> methodSet = methodObserverMap.keySet();
        for (String methodStr : methodSet) {
            List<MSObserver> msObserverList = methodObserverMap.get(methodStr);
            if ("serial".equals(methodStr)) {
                ProcessMethodSerial processMethodSerial = ProcessMethodSerial.getInstance();
                processMethodSerial.setMsObserverList(msObserverList);
                processMethodSerial.processMS();
            }
            else if ("parallel".equals(methodStr)) {
                ProcessMethodParallel processMethodParallel = ProcessMethodParallel.getInstance();
                processMethodParallel.setMsObserverList(msObserverList);
                processMethodParallel.processMS();
            }
        }

    }
}
