/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mas.request;

import mas.data.ApplicationDataSet;
import mas.data.Data;

/**
 *
 * @author cristopherson
 */
public class ApplicationRequest implements Request{
    private long id;
    private int type;
    private ApplicationDataSet dataSet;
    private long timeout;    

    public ApplicationRequest(long id, int type, ApplicationDataSet dataSet, long timeout) {
        this.id = id;
        this.type = type;
        this.dataSet = dataSet;
        this.timeout = timeout;
    }
    
    public ApplicationRequest() {
        this(0, 0, null, 0);
    }
    
    @Override
    public long getId() {
        return id;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public Data getDataSet() {
        return dataSet;
    }

    @Override
    public long getTimeout() {
        return timeout;
    }
    
}
