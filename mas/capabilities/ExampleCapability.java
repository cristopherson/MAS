/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas.capabilities;

import mas.agents.Message;
import bdi4jade.annotation.Belief;
import bdi4jade.annotation.Plan;
import bdi4jade.belief.BeliefSet;
import bdi4jade.belief.TransientBeliefSet;
import bdi4jade.core.Capability;
import bdi4jade.goal.Goal;
import bdi4jade.goal.GoalTemplateFactory;
import bdi4jade.plan.DefaultPlan;
import mas.goals.ExampleGoal;
import mas.plan.PrintMessagePlanBody;

/**
 *
 * @author cristopherson
 */
public final class ExampleCapability extends Capability {

    public static final String BELIEF_PRINT = "print";

    @Plan
    private bdi4jade.plan.Plan achievePrintMessagePlan = new DefaultPlan(
            GoalTemplateFactory.hasBeliefValueOfType(BELIEF_PRINT, String.class),
            PrintMessagePlanBody.class);

    @Belief
    private BeliefSet<String, Message> not_printed = new TransientBeliefSet<>(BELIEF_PRINT);

    private bdi4jade.plan.Plan performPrintPlan;

    public ExampleCapability() {
        this.performPrintPlan = new DefaultPlan(ExampleGoal.class, PrintMessagePlanBody.class) {
            @Override
            public boolean isContextApplicable(Goal goal) {
                if (goal instanceof ExampleGoal) {
                    ExampleGoal performMove = (ExampleGoal) goal;
                    return true;
                }
                return false;
            }
        };

    }

    protected void setup() {
        not_printed.addValue(new Message(""));
    }

}
