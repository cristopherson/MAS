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
import mas.capabilities.ExampleCapability;

/**
 *
 * @author cristopherson
 */
@GoalOwner(capability = ExampleCapability.class, internal = true)
public class ExampleGoal implements Goal {

    private final String message = "Hello";

    @Parameter(direction = Direction.IN)
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Message: " + message;
    }
}
