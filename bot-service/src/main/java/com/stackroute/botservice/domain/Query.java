package com.stackroute.botservice.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Query {


    private  String question;
    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Query(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }


    public Query() {
    }
}
