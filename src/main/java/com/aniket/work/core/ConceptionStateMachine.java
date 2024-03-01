package com.aniket.work.core;

import com.aniket.work.bootstrap.StateMachineCreator;

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

    Set<FSMStateHolder> getAllRecordedStates();

    Shift getLatestShift();

    Shift getPreviousShift();

    Set<Shift> getAllShifts();

    void recordFinalState(FSMStateHolder state);

    Event getLatestEvent();

    void recordShift(final Shift shift);

    void recordFinalState(final Set<FSMStateHolder> states);
}
