/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas.goals;

import bdi4jade.annotation.Belief;
import bdi4jade.annotation.Parameter;
import bdi4jade.belief.BeliefSet;
import bdi4jade.belief.TransientBeliefSet;
import bdi4jade.event.GoalEvent;
import bdi4jade.goal.GoalStatus;
import bdi4jade.plan.Plan.EndState;
import bdi4jade.plan.planbody.AbstractPlanBody;
import bdi4jade.plan.planbody.BeliefGoalPlanBody;
import mas.capabilities.ApplicationCapability;
import static mas.capabilities.ApplicationCapability.BELIEF_EMPTY_DATA;
import mas.data.ApplicationDataSet;

/**
 *
 * @author cristopherson
 */
public class ApplicationForwardRequestPlanBody extends BeliefGoalPlanBody {
    
    private ApplicationDataSet target;
    
    
    @Override
    public void execute() {
        GoalEvent goalEvent = getGoalEvent();
        System.out.println(ApplicationForwardRequestPlanBody.class);
        if (goalEvent == null) {
            return;
        } else if (!GoalStatus.ACHIEVED.equals(goalEvent.getStatus())) {
            setEndState(EndState.FAILED);
            return;
        }
        //System.out.println("BeliefBase " + getBeliefBase().getBeliefs());
        //setEndState(EndState.SUCCESSFUL);
        //return;
    }
    
    @Parameter(direction = Parameter.Direction.IN, mandatory = true)
    public void setApplicationDataSet(ApplicationDataSet applicationData) {        
        target = new ApplicationDataSet();
        target.setData(applicationData.getData());
    }
    
}
