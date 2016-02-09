/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mas.goals;

import bdi4jade.annotation.GoalOwner;
import bdi4jade.annotation.Parameter;
import bdi4jade.annotation.Parameter.Direction;
import bdi4jade.goal.Goal;
import mas.capabilities.ApplicationCapability;
import mas.data.ApplicationDataSet;

/**
 *
 * @author cristopherson
 */
@GoalOwner(capability = ApplicationCapability.class, internal = true)
public class GetApplicationData implements Goal{
    
    private ApplicationDataSet data;
    
    public GetApplicationData(ApplicationDataSet data) {
        this.data = data;
    }
    
    @Parameter(direction = Direction.IN)
    public ApplicationDataSet getApplicationData() {
        return this.data;
    }
}
