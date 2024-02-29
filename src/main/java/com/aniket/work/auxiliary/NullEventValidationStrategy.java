package com.aniket.work.auxiliary;

import com.aniket.work.core.Event;
import com.aniket.work.core.FSMStateHolder;

import java.util.Set;

public class NullEventValidationStrategy implements ValidationStrategy {

    /**
     * @param event
     * @param currentState
     * @return
     */
    @Override
    public boolean isValid(Event event, Set<FSMStateHolder> finalState, FSMStateHolder currentState) {
        return event != null;
    }
}
