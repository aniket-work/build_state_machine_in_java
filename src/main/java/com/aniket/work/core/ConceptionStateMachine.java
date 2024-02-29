package com.aniket.work.core;

import java.util.Set;

/**
 * Interface representing a state machine.
 */
public interface ConceptionStateMachine {

    /**
     * Triggers the state machine with the given event.
     *
     * @param event the event to trigger
     * @return the state holder after the trigger
     * @throws FSMException if an error occurs during the state transition
     */
    FSMStateHolder trigger(Event event) throws FSMException;

    FSMStateHolder getInitialState();

    FSMStateHolder getCurrentState();

    Set<FSMStateHolder> getFinalState();

    Set<FSMStateHolder> getAllRegisteredStates();

    Shift getLatestShift();

    Shift getPreviousShift();

    Set<Shift> getAllShifts();

    Event getLatestEvent();

}
