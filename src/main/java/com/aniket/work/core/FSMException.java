package com.aniket.work.core;

public class FSMException extends Exception {
    public FSMException() {
        super();
    }

    public FSMException(String message) {
        super(message);
    }

    public FSMException(String message, Throwable cause) {
        super(message, cause);
    }

    public FSMException(Throwable cause) {
        super(cause);
    }

    public FSMException(Shift transition, Event event, Exception e) {
    }
}

