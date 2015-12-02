/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas.plan;

import bdi4jade.annotation.Parameter;
import bdi4jade.annotation.Parameter.Direction;
import bdi4jade.event.GoalEvent;
import bdi4jade.goal.BeliefSetHasValueGoal;
import bdi4jade.goal.GoalStatus;
import bdi4jade.plan.Plan.EndState;
import bdi4jade.plan.planbody.BeliefGoalPlanBody;
import mas.capabilities.ExampleCapability;

/**
 *
 * @author cristopherson
 */
public class PrintMessagePlanBody extends BeliefGoalPlanBody {

    private int counter;
    private String messageDeliver;

    @Override
    protected void execute() {

        if (counter != 0) {
            GoalEvent goalEvent = getGoalEvent();

            if (goalEvent == null) {
                return;
            } else if (!GoalStatus.ACHIEVED.equals(goalEvent.getStatus())) {
                setEndState(EndState.FAILED);
                return;
            }

        }
        dispatchSubgoalAndListen(new BeliefSetHasValueGoal<String, String>(
                ExampleCapability.BELIEF_PRINT, messageDeliver));
    }

    private String getMessage(String message) {
        return message;
    }

    @Override
    public int onEnd() {
        return super.onEnd();
    }

    @Override
    public void init() {
        this.counter = 0;
    }

    /**
     * This method sets the message to be achieved.
     *
     * @param message the message to set.
     */
    @Parameter(direction = Direction.IN, mandatory = true)
    public void setValue(String message) {
        this.messageDeliver = message;
    }

}
