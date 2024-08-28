package com.demo.dto;

import com.demo.state.State;
import com.demo.state.impl.Analysis;

public class Ticket {

    private String description;
    private User createdBy;
    private State ticketState;

    public Ticket(String description, User createdBy) {
        this.description = description;
        this.createdBy = createdBy;
        ticketState=Analysis.getInstance();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public State getTicketState() {
        return ticketState;
    }

    public void setTicketState(State ticketState) {
        this.ticketState = ticketState;
    }
}
