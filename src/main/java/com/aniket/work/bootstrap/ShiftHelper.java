package com.aniket.work.bootstrap;

import com.aniket.work.core.Event;
import com.aniket.work.core.FSMStateHolder;
import com.aniket.work.core.Shift;
import com.aniket.work.core.TriggerHandler;

public class ShiftHelper<E extends Event> implements Shift {
    /**
     * @return
     */
    @Override
    public String shiftName() {
        return name;
    }

    /**
     * @return
     */
    @Override
    public FSMStateHolder getFromState() {
        return fromState;
    }

    /**
     * @return
     */
    @Override
    public FSMStateHolder getToState() {
        return toState;
    }

    /**
     * @return
     */
    @Override
    public Class<? extends Event> getTriggeredEventNature() {
        return eventType;
    }

    /**
     * @return
     */
    @Override
    public TriggerHandler<? extends Event> getTriggerHandler() {
        return triggerHandler;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFromState(FSMStateHolder fromState) {
        this.fromState = fromState;
    }

    public void setToState(FSMStateHolder toState) {
        this.toState = toState;
    }

    public void setEventType(Class<E> eventType) {
        this.eventType = eventType;
    }

    public void setTriggerHandler(TriggerHandler<E> triggerHandler) {
        this.triggerHandler = triggerHandler;
    }

    private String name;
    private FSMStateHolder fromState;
    private FSMStateHolder toState;
    private Class<E> eventType;
    private TriggerHandler<E> triggerHandler;
}
