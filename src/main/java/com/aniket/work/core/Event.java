package com.aniket.work.core;

import java.util.UUID;

public interface Event {

    UUID getEventID();

    long getEventTimestamp();

    String getEventSource();

    String getEventName();
}
