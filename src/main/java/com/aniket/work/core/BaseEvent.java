package com.aniket.work.core;

import java.util.UUID;

/**
 * Abstract base class representing an event in the state machine.
 */
public abstract class BaseEvent implements Event {

    protected UUID eventID;
    protected long eventTimestamp;
    protected String eventName;
    protected String eventSource;

    /**
     * Constructs a BaseEvent with the specified name and source.
     *
     * @param eventName   the name of the event
     * @param eventSource the source of the event
     */
    protected BaseEvent(String eventName, String eventSource) {
        this.eventID        = UUID.randomUUID();
        this.eventTimestamp = System.currentTimeMillis();
        this.eventName      = eventName;
        this.eventSource    = eventSource;
    }

    // Getters for event properties
}
