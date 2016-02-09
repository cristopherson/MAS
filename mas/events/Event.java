/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mas.events;

import mas.data.Data;

/**
 *
 * @author cristopherson
 */
public interface Event {
    long getId();
    int getType();
    long getPayload();
    Data getData();
}
