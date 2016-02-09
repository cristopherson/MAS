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
public class AgentFilterEvent implements Event {
    private long id;
    private int type;
    private long payload;
    private Data data;

    public AgentFilterEvent(long id, int type, long payload, Data data) {
        this.id = id;
        this.type = type;
        this.payload = payload;
        this.data = data;
    }

    public AgentFilterEvent() {
        this(0, 0, 0, null);
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
    public long getPayload() {
        return payload;
    }

    @Override
    public Data getData() {
        return data;
    }

}
