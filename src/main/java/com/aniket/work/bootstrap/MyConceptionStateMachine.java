package com.aniket.work.bootstrap;

import com.aniket.work.auxiliary.FinalStateValidationStrategy;
import com.aniket.work.auxiliary.NullEventValidationStrategy;
import com.aniket.work.auxiliary.ValidationStrategy;
import com.aniket.work.core.*;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConceptionStateMachine implements ConceptionStateMachine {
    private static final Logger log = Logger.getLogger(MyConceptionStateMachine.class.getSimpleName());

    private ValidationStrategy finalStateValidationStrategy = new FinalStateValidationStrategy();
    private ValidationStrategy nullEventValidationStrategy = new NullEventValidationStrategy();


    public MyConceptionStateMachine(FSMStateHolder initialState, Set<FSMStateHolder> states) {
        this.initialState   = initialState;
        this.finalStates    = new HashSet<>();
        this.states         = states;
        this.shifts = new HashSet<>();
    }

    /**
     * Triggers the state machine with the given event.
     *
     * @param event the event to trigger
     * @return the state holder after the trigger
     * @throws FSMException if an error occurs during the state transition
     */
    @Override
    public FSMStateHolder trigger(Event event) throws FSMException {

        if (!finalStateValidationStrategy.isValid(event, finalStates, currentState)) {
            log.log(Level.WARNING, "State Machine is in final state '" + currentState.fetchFSMStateName() + "', event " + event + " is ignored.");
            return currentState;
        }

        if (!nullEventValidationStrategy.isValid(event, finalStates, currentState)) {
            log.log(Level.WARNING, "Null event fired, State Machine's state unchanged");
            return currentState;
        }

        manageShift(event);

        return currentState;
    }

    /**
     * Manages state transitions based on incoming events in the Finite State Machine (FSM).
     *
     * @param event The event triggering the state transition.
     * @throws FSMException If an error occurs during the state transition.
     */
    public void manageShift(Event event) throws FSMException {
        for (Shift shift : shifts) {
            // Check if the FSM is in the expected state for the current shift, the fired event type matches the shift definition,
            // and the target state is defined.
            if (currentState.equals(shift.getFromState()) &&
                    shift.getTriggeredEventNature().equals(event.getClass()) &&
                    states.contains(shift.getToState())) {
                try {
                    // Perform action associated with the shift, if any.
                    TriggerHandler<?> triggerHandler = shift.getTriggerHandler();
                    if (triggerHandler != null) {
                        triggerHandler.handleEventTrigger(event);
                    }

                    // Transit to the target state.
                    currentState = shift.getToState();

                    // Save the last triggered event and shift.
                    latestEvent = event;
                    lastShift = shift;

                    break; // Exit the loop once a valid shift is found and processed.
                } catch (Exception e) {
                    log.log(Level.SEVERE, "An exception occurred during handling event " + event + " for shift " + shift, e);
                    throw new FSMException(shift, event, e);
                }
            }
        }
    }


    /**
     * @return
     */
    @Override
    public FSMStateHolder getInitialState() {
        return initialState;
    }

    /**
     * @return
     */
    @Override
    public FSMStateHolder getCurrentState() {
        return currentState;
    }

    /**
     * @return
     */
    @Override
    public Set<FSMStateHolder> getFinalState() {return finalStates;}

    /**
     * @return
     */
    @Override
    public Set<FSMStateHolder> getAllRegisteredStates() {
        return states;
    }

    /**
     * @return
     */
    @Override
    public Shift getLatestShift() {
        return lastShift;
    }

    /**
     * @return
     */
    @Override
    public Shift getPreviousShift() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Set<Shift> getAllShifts() {
        return shifts;
    }

    /**
     * @return
     */
    @Override
    public Event getLatestEvent() {
        return latestEvent;
    }

    private FSMStateHolder currentState;
    private final FSMStateHolder initialState;
    private final Set<FSMStateHolder> finalStates;
    private final Set<FSMStateHolder> states;
    private final Set<Shift> shifts;
    private Event latestEvent;
    private Shift lastShift;
}
