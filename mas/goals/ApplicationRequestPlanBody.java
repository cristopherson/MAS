/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas.goals;

import bdi4jade.annotation.Belief;
import bdi4jade.annotation.Parameter;
import bdi4jade.annotation.Parameter.Direction;
import bdi4jade.belief.BeliefSet;
import bdi4jade.plan.Plan.EndState;
import bdi4jade.plan.planbody.AbstractPlanBody;
import java.util.HashMap;
import mas.capabilities.ApplicationCapability;
import mas.data.ApplicationDataSet;

/**
 *
 * @author cristopherson
 */
public class ApplicationRequestPlanBody extends AbstractPlanBody {

    @Belief(name = ApplicationCapability.BELIEF_EMPTY_DATA)
    private BeliefSet<String, ApplicationDataSet> emptyData;
    @Belief(name = ApplicationCapability.BELIEF_GET_DATA)
    private BeliefSet<String, ApplicationDataSet> getData;
    private ApplicationDataSet applicationDataSet;

    @Override
    public void action() {
        //Wait for communication from communication agent
        applicationDataSet = new ApplicationDataSet();        
        HashMap map = new HashMap<String, String>();
        ApplicationDataSet applicationDataSet = new ApplicationDataSet();
        map.put("key", "name");
        applicationDataSet.setData(map);
        System.out.println(ApplicationRequestPlanBody.class);
        emptyData.addValue(applicationDataSet);
        if (applicationDataSet != null && applicationDataSet.getData()!=null) {
            setEndState(EndState.SUCCESSFUL);
        }
    }

    @Parameter(direction = Direction.IN, mandatory = true)
    public void setApplicationDataSet(ApplicationDataSet applicationDataSet) {
        this.applicationDataSet = new ApplicationDataSet();
        this.applicationDataSet = applicationDataSet;
    }
    
    @Parameter(direction = Direction.OUT, mandatory = true)
    public ApplicationDataSet getApplicationDataSet() {
        return this.applicationDataSet;
    }
    
}
