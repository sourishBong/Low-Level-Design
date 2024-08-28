package com.demo.services;

import com.demo.dto.Ticket;
import com.demo.dto.User;
import com.demo.state.impl.Analysis;
import com.demo.state.impl.Done;
import com.demo.state.impl.Review;

import java.util.concurrent.locks.ReentrantLock;

public class TicketService {

    private final ReentrantLock lock=new ReentrantLock();

    public Ticket createTicket(String description, User createdBy){
        return new Ticket(description,createdBy);
    }

    public void startAnalysis(Ticket ticket,User user){
        boolean  isFeasible=ticket.getTicketState().startAnalysis(ticket,user);
        if(isFeasible){
            //we are using lock to avoid to threads entering the critical section at the same time
            lock.lock();
            if(ticket.getTicketState().startAnalysis(ticket,user)) {
                ticket.setTicketState(Analysis.getInstance());
            }
            lock.unlock();
        }
    }

    public void startReview(Ticket ticket,User user){
        boolean  isFeasible=ticket.getTicketState().startReview(ticket,user);
        if(isFeasible){
            //we are using lock to avoid to threads entering the critical section at the same time
            lock.lock();
            if(ticket.getTicketState().startReview(ticket,user)) {
                ticket.setTicketState(Review.getInstance());
            }
            lock.unlock();
        }
    }

    public void startDone(Ticket ticket,User user){
        boolean  isFeasible=ticket.getTicketState().markDone(ticket,user);
        if(isFeasible){
            //we are using lock to avoid to threads entering the critical section at the same time
            lock.unlock();
            if(ticket.getTicketState().startReview(ticket,user)) {
                ticket.setTicketState(Done.getInstance());
            }
            lock.unlock();
        }
    }

//    public void changeTicketState(Ticket ticket, TicketState newState,User user){

//    }
}
