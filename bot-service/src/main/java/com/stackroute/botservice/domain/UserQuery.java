package com.stackroute.botservice.domain;


public class UserQuery {

    private Query query;
    private Status status;

    @Override
    public String toString() {
        return "UserQuery{" +
                "query=" + query +
                ", status=" + status +
                '}';
    }

    public UserQuery(Query query, Status status) {
        this.query = query;
        this.status = status;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
