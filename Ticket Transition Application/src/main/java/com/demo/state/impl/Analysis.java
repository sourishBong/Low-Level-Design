package com.demo.state.impl;

import com.demo.dto.Ticket;
import com.demo.dto.User;
import com.demo.enums.TicketState;
import com.demo.state.State;

public class Analysis implements State {

    private static Analysis analysis=null;

    private Analysis(){

    }

    public static Analysis getInstance(){
        if(analysis==null){
            synchronized (Analysis.class){
                if(analysis==null){
                    analysis=new Analysis();
                }
            }
        }
        return analysis;
    }

    public boolean startAnalysis(Ticket ticket, User user) {
        System.out.println("Ticket Already in Analysis state");
        return false;
    }

    public boolean startReview(Ticket ticket, User user) {
        System.out.println(ticket.getDescription()+" moved from "+ TicketState.ANALYSIS+" to "+TicketState.REVIEW);
        return true;
    }

    public boolean markDone(Ticket ticket, User user) {
        System.out.println(ticket.getDescription()+" moved from "+ TicketState.ANALYSIS+" to "+TicketState.DONE);
        return true;
    }
}
