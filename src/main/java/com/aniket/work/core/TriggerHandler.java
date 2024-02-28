package com.aniket.work.core;

public interface TriggerHandler <E extends Event> {

    EventStatStore handleEventTrigger(E event) throws FSMException;
}
