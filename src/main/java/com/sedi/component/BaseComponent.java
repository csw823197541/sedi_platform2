package com.sedi.component;

import java.util.logging.Logger;

/**
 * Created by csw on 2016/11/4 12:11.
 * Explain:
 */
public abstract class BaseComponent {

    protected final Logger log;

    public BaseComponent() {
        this.log = Logger.getLogger(String.valueOf(this.getClass()));
    }
}
