package com.aniket.work.auxiliary;

import com.aniket.work.core.Event;
import com.aniket.work.core.FSMStateHolder;

import java.util.Set;

/**
 * Defines the contract for validation strategies used in the Conception State Machine .
 */
public interface ValidationStrategy {

    /**
     * Determines whether the provided event is valid given the current state of the Conception State Machine.
     *
     * @param event         The event to be validated.
     * @param finalStates   The set of final states in the Conception State Machine.
     * @param currentState  The current state of the Conception State Machine.
     * @return              {@code true} if the event is valid; {@code false} otherwise.
     */
    boolean isValid(Event event, Set<FSMStateHolder> finalStates, FSMStateHolder currentState);
}


