package com.demo.state.impl;

import com.demo.dto.Ticket;
import com.demo.dto.User;
import com.demo.enums.TicketState;
import com.demo.state.State;

public class Done implements State {

    private static Done done=null;

    private Done(){}

    public static Done getInstance(){
        if(done==null){
            synchronized (Done.class){
                if(done==null){
                    done=new Done();
                }
            }
        }
        return done;
    }

    public boolean startAnalysis(Ticket ticket, User user) {
        System.out.println(ticket.getDescription()+" moved from "+ TicketState.DONE+" to "+TicketState.ANALYSIS);
        return true;
    }

    public boolean startReview(Ticket ticket, User user) {
        System.out.println(ticket.getDescription()+" moved from "+ TicketState.DONE+" to "+TicketState.REVIEW);
        return true;
    }

    public boolean markDone(Ticket ticket, User user) {
        System.out.println("Ticket Already in Done state");
        return false;
    }
}
