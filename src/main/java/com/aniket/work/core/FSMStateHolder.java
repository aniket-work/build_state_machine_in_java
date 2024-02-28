package com.aniket.work.core;

public class FSMStateHolder {

    private final String fsmStateName;

    public FSMStateHolder(String fsmStateName) {
        this.fsmStateName = fsmStateName;
    }

    public String fetchFSMStateName(){
        return fsmStateName;
    }
}
