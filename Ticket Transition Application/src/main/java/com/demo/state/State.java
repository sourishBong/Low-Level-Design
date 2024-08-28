package com.demo.state;

import com.demo.dto.Ticket;
import com.demo.dto.User;

public interface State {

    boolean startAnalysis(Ticket ticket, User user);
    boolean startReview(Ticket ticket, User user);
    boolean markDone(Ticket ticket, User user);

}
