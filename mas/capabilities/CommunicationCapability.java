/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas.capabilities;

import bdi4jade.annotation.Belief;
import bdi4jade.annotation.Plan;
import bdi4jade.belief.BeliefSet;
import bdi4jade.belief.TransientBeliefSet;
import bdi4jade.core.Capability;
import bdi4jade.goal.GoalTemplateFactory;
import bdi4jade.plan.DefaultPlan;
import java.util.HashMap;
import mas.data.ApplicationDataSet;
import mas.goals.ApplicationForwardRequestPlanBody;
import mas.goals.ApplicationGetDataPlanBody;
import mas.goals.ApplicationRequestPlanBody;
import mas.goals.GetApplicationData;
import mas.plan.ForwardRequestPlan;

/**
 *
 * @author cristopherson
 */
public class CommunicationCapability extends Capability {

    public static final String BELIEF_EMPTY_DATA = "empty_data";
    public static final String BELIEF_GET_DATA = "get_data";

    @Plan
    private bdi4jade.plan.Plan forwardRequest = new DefaultPlan(
            GoalTemplateFactory.hasBeliefValueOfType(BELIEF_EMPTY_DATA, ApplicationDataSet.class),
            ApplicationForwardRequestPlanBody.class);

    @Plan
    private bdi4jade.plan.Plan achieveGetData = new DefaultPlan(
            GoalTemplateFactory.hasBeliefValueOfType(BELIEF_GET_DATA, ApplicationDataSet.class),
            ApplicationGetDataPlanBody.class);

    @Belief
    private BeliefSet<String, ApplicationDataSet> empty = new TransientBeliefSet<>(
            BELIEF_EMPTY_DATA);

    @Belief
    private BeliefSet<String, ApplicationDataSet> noEmpty = new TransientBeliefSet<>(BELIEF_GET_DATA);

    @Plan
    private bdi4jade.plan.Plan requestData;
    
    public CommunicationCapability(){
        this.requestData = new ForwardRequestPlan(GetApplicationData.class, ApplicationRequestPlanBody.class);                
    }
    
    protected void setup() {
        //Communicate with communication agents   
        System.out.println("Setup for = " + this.getClass());
        ApplicationDataSet data = new ApplicationDataSet();
        HashMap map = new HashMap<String, String>();
        map.put("key", "name");
        data.setData(map);
        empty.addValue(data);        

    }
}
