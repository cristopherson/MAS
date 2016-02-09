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
import mas.data.ApplicationData;

/**
 *
 * @author cristopherson
 */
public class ApplicationRequestPlanBody extends AbstractPlanBody {

    @Belief(name = ApplicationCapability.BELIEF_EMPTY_DATA)
    private BeliefSet<String, ApplicationData> emptyData;
    @Belief(name = ApplicationCapability.BELIEF_GET_DATA)
    private BeliefSet<String, ApplicationData> getData;
    private ApplicationData applicationData;

    @Override
    public void action() {
        //Wait for communication from communication agent
        applicationData = new ApplicationData();        
        HashMap map = new HashMap<String, String>();
        ApplicationData applicationData = new ApplicationData();        
        map.put("key", "name");
        applicationData.setData(map);
        System.out.println(ApplicationRequestPlanBody.class);
        emptyData.addValue(applicationData);
        if (applicationData != null && applicationData.getData()!=null) {
            setEndState(EndState.SUCCESSFUL);
        }
    }

    @Parameter(direction = Direction.IN, mandatory = true)
    public void setApplicationData(ApplicationData applicationData) {
        this.applicationData = applicationData;
    }
    
}
