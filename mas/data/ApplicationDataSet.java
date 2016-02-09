/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author cristopherson
 */
public class ApplicationDataSet implements Data {

    private Map<String, Object> applicationDataSet;

    @Override
    public void setData(Object obj) {
        applicationDataSet = (HashMap) obj;
    }

    @Override
    public Object getData() {
        return applicationDataSet;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ApplicationDataSet) {
            ApplicationDataSet other = (ApplicationDataSet) obj;
            Set keys = ((Map) this.getData()).keySet();

            for (Object key : keys) {
                if (((Map) other.getData()).containsKey(key)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) Math.pow(applicationDataSet.hashCode(), applicationDataSet.hashCode());
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("ApplicationDataSet");
        Set keys = ((Map) this.getData()).keySet();
        for (Object key : keys) {
            sb.append("").append(key);
            sb.append(":").append(((Map)getData()).get(key));
        }
        return sb.toString();
    }

}
