package com.stackroute.manualservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserQuery {


    //Declaration

    @Id
    private String id;
    private String question;
    private String answer;

    //Constructor
    public UserQuery(String id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    //To string method

    @Override
    public String toString() {
        return "UserQuery{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    //Getter and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public String setQuestion(String question) {
        this.question = question;
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String setAnswer(String answer) {
        this.answer = answer;
        return answer;
    }
}
