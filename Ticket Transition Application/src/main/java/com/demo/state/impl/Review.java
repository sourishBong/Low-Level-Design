package com.demo.state.impl;

import com.demo.dto.Ticket;
import com.demo.dto.User;
import com.demo.enums.TicketState;
import com.demo.state.State;

public class Review implements State {

    private static Review review=null;

    private Review(){
    }

    public static Review getInstance(){
        if(review==null){
            synchronized (Review.class){
                if(review==null){
                    review=new Review();
                }
            }
        }
        return review;
    }

    public boolean startAnalysis(Ticket ticket, User user) {
        System.out.println(ticket.getDescription()+" moved from "+ TicketState.REVIEW+" to "+TicketState.ANALYSIS);
        return true;
    }

    public boolean startReview(Ticket ticket, User user) {
        System.out.println("Ticket Already in Review state");
        return false;
    }

    public boolean markDone(Ticket ticket, User user) {
        System.out.println(ticket.getDescription()+" moved from "+ TicketState.REVIEW+" to "+TicketState.DONE);
        return true;
    }
}
