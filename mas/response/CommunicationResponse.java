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
public class CommunicationResponse implements Response {
    private long id;
    private int type;
    private HashMap<String, Object>dictionary;

    public CommunicationResponse(long id, int type, HashMap<String, Object>dictionary) {
        this.id = id;
        this.type = type;
        this.dictionary = dictionary;
    }
    
    public CommunicationResponse() {
        this(0, 0, null);
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
    public HashMap<String, Object> getDictionary() {
        return dictionary;
    }    
}
