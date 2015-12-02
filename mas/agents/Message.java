/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas.agents;

/**
 *
 * @author cristopherson
 */
public class Message {

    private String message;
    
    
    public Message() {
        this("");
    }
    
    public Message(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof String) {
            String other = (String) obj;
            return this.message.equals(other);
        } else {
            return false;
        }
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Message");
        sb.append("_").append(message);
        return sb.toString();
    }

}
