/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas.goals;

import bdi4jade.annotation.Parameter;
import bdi4jade.annotation.Parameter.Direction;
import bdi4jade.event.GoalEvent;
import bdi4jade.goal.GoalStatus;
import bdi4jade.plan.Plan.EndState;
import bdi4jade.plan.planbody.BeliefGoalPlanBody;
import mas.data.ApplicationDataSet;

/**
 *
 * @author cristopherson
 */
public class ApplicationGetDataPlanBody extends BeliefGoalPlanBody {

    private ApplicationDataSet target;

    @Override
    protected void execute() {
        GoalEvent goalEvent = getGoalEvent();
        System.out.println(ApplicationGetDataPlanBody.class);
        if (goalEvent == null) {
            return;
        } else if (!GoalStatus.ACHIEVED.equals(goalEvent.getStatus())) {
            setEndState(EndState.FAILED);
            return;
        }
    }

    @Parameter(direction = Direction.IN, mandatory = true)
    public void setValue(Object obj) {
        target = new ApplicationDataSet();
        target.setData(obj);
    }

}
