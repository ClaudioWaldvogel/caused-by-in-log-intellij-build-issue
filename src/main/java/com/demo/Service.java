package com.demo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Service {

    private static final Logger LOG = Logger.getLogger(Service.class.getName());

    public void callFailingExternalServiceAndLogException() {
        try {
            throw new RuntimeException(new IllegalStateException("Oh oh"));
        } catch (Exception e) {
            LOG.log(Level.WARNING, e.getMessage(), e);
            //throw new IllegalArgumentException(e);
        }
    }

}
