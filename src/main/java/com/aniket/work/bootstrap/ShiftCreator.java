package com.aniket.work.bootstrap;

import com.aniket.work.core.Event;
import com.aniket.work.core.FSMStateHolder;
import com.aniket.work.core.Shift;
import com.aniket.work.core.TriggerHandler;

public class ShiftCreator {

    private final ShiftHelper shiftHelper;


    public ShiftCreator(ShiftHelper shiftHelper) {
        this.shiftHelper = shiftHelper;
    }

    public ShiftCreator name(final String name) {
        shiftHelper.setName(name);
        return this;
    }

    public ShiftCreator fromState(final FSMStateHolder sourceState) {
        shiftHelper.setFromState(sourceState);
        return this;
    }

    public ShiftCreator toState(final FSMStateHolder toState) {
        shiftHelper.setToState(toState);
        return this;
    }

    public ShiftCreator eventType(final Class<? extends Event> eventType) {
        shiftHelper.setEventType(eventType);
        return this;
    }

    public <E extends Event> ShiftCreator eventHandler(final TriggerHandler<E> eventHandler) {
        shiftHelper.setTriggerHandler(eventHandler);
        return this;
    }

    public Shift create() {
        return shiftHelper;
    }
}
