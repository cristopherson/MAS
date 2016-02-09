/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mas.response;

import java.util.HashMap;

/**
 *
 * @author cristopherson
 */
public interface Response {
    long getId();
    int getType();
    HashMap<String, Object> getDictionary();
}
