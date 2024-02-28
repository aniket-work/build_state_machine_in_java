package com.aniket.work.core;

/**
 * Class for storing event-related statistics.
 */
public class EventStatStore {

    private String eventContext;
    private String eventMetaData;

    public String getEventContext() {
        return eventContext;
    }

    public void setEventContext(String eventContext) {
        this.eventContext = eventContext;
    }

    public String getEventMetaData() {
        return eventMetaData;
    }

    public void setEventMetaData(String eventMetaData) {
        this.eventMetaData = eventMetaData;
    }
}
