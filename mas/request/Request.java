/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mas.request;

import mas.data.Data;

/**
 *
 * @author cristopherson
 */
public interface Request {
    long getId();
    int getType();
    Data getDataSet();
    long getTimeout();
}
