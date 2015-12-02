/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas.goals;

import bdi4jade.annotation.Parameter;
import bdi4jade.plan.planbody.BeliefGoalPlanBody;
import mas.data.ApplicationData;

/**
 *
 * @author cristopherson
 */
public class ApplicationForwardRequestPlanBody extends BeliefGoalPlanBody {

    private ApplicationData target;
    
    @Override
    protected void execute() {
        //Should communicate with communication agent
        return;
    }

    @Parameter(direction = Parameter.Direction.IN, mandatory = true)
    public void setValue(Object obj) {
        target = new ApplicationData();
        target.setData(obj);
    }
}
