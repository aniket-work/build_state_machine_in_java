package com.aniket.work.core;

import java.util.UUID;

public abstract class BaseEvent implements Event {

    protected UUID eventID;
    protected long eventTimestamp;
    protected String eventName;
    protected String eventSource;

    protected BaseEvent(String eventName, String eventSource) {
        this.eventID        = UUID.randomUUID();
        this.eventTimestamp = System.currentTimeMillis();
        this.eventName      = eventName;
        this.eventSource    = eventSource;
    }

    @Override
    public String getEventName() {
        return eventName;
    }

    @Override
    public String getEventSource() {
        return eventSource;
    }

}
