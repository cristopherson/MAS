/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mas.listener;

import bdi4jade.event.GoalEvent;
import bdi4jade.event.GoalListener;
import javax.swing.JTextArea;

/**
 *
 * @author cristopherson
 */
public class ApplicationListener implements GoalListener{
    
    private JTextArea textArea = null;
    
    public ApplicationListener(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void goalPerformed(GoalEvent ge) {
        this.textArea.append("Achieved goal");
    }
    
}
