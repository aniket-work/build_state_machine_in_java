package com.aniket.work.core;

/**
 * Interface for handling event triggers.
 */
public interface TriggerHandler<E extends Event> {

    /**
     * Handles the trigger of an event.
     *
     * @param event the event to handle
     * @return event statistics
     * @throws FSMException if an error occurs during event handling
     */
    EventStatStore handleEventTrigger(Event event) throws FSMException;
}
