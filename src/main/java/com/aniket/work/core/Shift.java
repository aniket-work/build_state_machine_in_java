package com.aniket.work.core;

/**
 * Interface representing a shift between states triggered by events.
 */
public interface Shift {

    String ShiftName();

    FSMStateHolder getFromState();

    FSMStateHolder getToState();

    Class<? extends Event> getTriggeredEventNature();

    TriggerHandler<?> getTriggerHandler();
}
