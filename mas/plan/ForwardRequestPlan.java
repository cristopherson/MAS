/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas.plan;

import bdi4jade.goal.Goal;
import bdi4jade.plan.DefaultPlan;
import mas.goals.GetApplicationData;

/**
 *
 * @author cristopherson
 */
public class ForwardRequestPlan extends DefaultPlan {

    public ForwardRequestPlan(Class class1, Class class2) {
        super(class1, class2);
    }

    public boolean isContextApplicable(Goal goal) {
        if (goal instanceof GetApplicationData) {
            return true;
        }
        return false;
    }
}
