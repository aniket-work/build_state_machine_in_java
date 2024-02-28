package com.aniket.work.core;

/**
 * Class representing a state within the state machine.
 */
public class FSMStateHolder {

    private final String fsmStateName;

    public FSMStateHolder(String fsmStateName) {
        this.fsmStateName = fsmStateName;
    }

    public String fetchFSMStateName(){
        return fsmStateName;
    }
}
