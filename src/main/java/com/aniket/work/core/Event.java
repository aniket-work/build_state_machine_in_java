package com.aniket.work.core;

import java.util.UUID;

/**
 * Interface representing an event in the state machine.
 */
public interface Event {

    UUID getEventID();

    long getEventTimestamp();

    String getEventSource();

    String getEventName();
}
