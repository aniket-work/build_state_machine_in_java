package com.aniket.work.core;

import java.util.Set;

public interface ConceptionStateMachine {

    FSMStateHolder trigger(Event event) throws  FSMException;

    FSMStateHolder getInitialState();

    FSMStateHolder getCurrentState();

    FSMStateHolder getFinalState();

    Set<FSMStateHolder> getAllRegisteredStates();

    Shift getLatestShift();

    Shift getPreviousShift();

    Set<Shift> getAllShifts();

    Event getLatestEvent();

}
