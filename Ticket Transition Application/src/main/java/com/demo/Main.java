package com.demo;

import com.demo.dto.Ticket;
import com.demo.dto.User;
import com.demo.services.TicketService;

public class Main {

    public static void main(String[] args) {
        User u1=new User("a");
        Ticket ticket1=new Ticket("first ticket",u1);

        TicketService ticketService=new TicketService();

        //will through error since already in analysis state
        ticketService.startAnalysis(ticket1,u1);

        ticketService.startReview(ticket1,u1);
    }
}
