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
public class ApplicationData implements Data {

    private Map<String, Object> applicationData;

    @Override
    public void setData(Object obj) {
        applicationData = (HashMap) obj;
    }

    @Override
    public Object getData() {
        return applicationData;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ApplicationData) {
            ApplicationData other = (ApplicationData) obj;
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
        return (int) Math.pow(applicationData.hashCode(), applicationData.hashCode());
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("ApplicationData");
        Set keys = ((Map) this.getData()).keySet();
        for (Object key : keys) {
            sb.append("").append(key);
            sb.append(":").append(((Map)getData()).get(key));
        }
        return sb.toString();
    }

}
