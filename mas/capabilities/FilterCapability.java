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
public class FilterCapability extends Capability {

    public static final String RECEIVE_EVENT = "receive_event";
    public static final String RECEIVE_REQUEST = "receive_request";

    @Plan
    private bdi4jade.plan.Plan receiveEvent = new DefaultPlan(
            GoalTemplateFactory.hasBeliefValueOfType(RECEIVE_EVENT, ApplicationDataSet.class),
            ApplicationForwardRequestPlanBody.class);

    @Plan
    private bdi4jade.plan.Plan receiveRequest = new DefaultPlan(
            GoalTemplateFactory.hasBeliefValueOfType(RECEIVE_REQUEST, ApplicationDataSet.class),
            ApplicationGetDataPlanBody.class);

    @Belief
    private BeliefSet<String, ApplicationDataSet> empty = new TransientBeliefSet<>(
            RECEIVE_EVENT);

    @Belief
    private BeliefSet<String, ApplicationDataSet> noEmpty = new TransientBeliefSet<>(RECEIVE_REQUEST);

    @Plan
    private bdi4jade.plan.Plan requestData;
    
    public FilterCapability(){
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
