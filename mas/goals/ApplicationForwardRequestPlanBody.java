/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas.goals;

import bdi4jade.annotation.Belief;
import bdi4jade.annotation.Parameter;
import bdi4jade.belief.BeliefSet;
import bdi4jade.plan.planbody.AbstractPlanBody;
import bdi4jade.plan.planbody.BeliefGoalPlanBody;
import mas.capabilities.ApplicationCapability;
import mas.data.ApplicationData;

/**
 *
 * @author cristopherson
 */
public class ApplicationForwardRequestPlanBody extends AbstractPlanBody {

    private ApplicationData target;
    @Belief(name = ApplicationCapability.BELIEF_EMPTY_DATA)
    private BeliefSet<String, ApplicationData> emptyData;
    @Belief(name = ApplicationCapability.BELIEF_GET_DATA)
    private BeliefSet<String, ApplicationData> getData;
    private ApplicationData applicationData;

    @Override
    public void action() {
        //Should communicate with communication agent
        System.out.println(ApplicationForwardRequestPlanBody.class);
        target = new ApplicationData();
        return;
    }

    @Parameter(direction = Parameter.Direction.IN, mandatory = true)
    public void setApplicationData(ApplicationData obj) {        
        target = obj;
    }

    @Parameter(direction = Parameter.Direction.OUT, mandatory = true)
    public ApplicationData getApplicationData() {
        return (ApplicationData)target.getData();
    }
}
