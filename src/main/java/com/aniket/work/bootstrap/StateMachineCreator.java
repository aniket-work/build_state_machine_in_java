package com.aniket.work.bootstrap;

import com.aniket.work.core.FSMStateHolder;
import com.aniket.work.core.Shift;

import java.util.Set;

public class StateMachineCreator {

    private final MyConceptionStateMachine myConceptionStateMachine;

    public StateMachineCreator(final FSMStateHolder initialState, final Set<FSMStateHolder> states) {
        this.myConceptionStateMachine = new MyConceptionStateMachine(initialState, states);
    }

    public StateMachineCreator recordShift(final Shift shift){
        myConceptionStateMachine.recordShift(shift);
        return this;
    }

    public StateMachineCreator recordFinalState(final Set<FSMStateHolder> states){
        for(FSMStateHolder state : states){
            myConceptionStateMachine.recordFinalState(state);
        }
        return this;
    }

    public MyConceptionStateMachine create(){return myConceptionStateMachine;}
}
