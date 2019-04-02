package com.stackroute.botservice.domain;

import org.springframework.data.mongodb.core.mapping.Document;


public class Status {

    boolean answered;
    boolean accepted;

    public Status(boolean answered, boolean accepted) {
        this.answered = answered;
        this.accepted = accepted;
    }

    public Status() {
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
