package com.stackroute.manualservice.service;

import com.stackroute.manualservice.domain.QueryData;

import java.util.List;

public interface ManualService {

    //Save user
    public QueryData saveUser(QueryData userQuery);

    //get List of QueryData
    public List<QueryData> getListOfQuestions();


    //Update Question
    public QueryData updateQuestion(QueryData user);

    //Delete Question
    public QueryData deleteQuestion(String queryId);

    //

    //Get Question by Topic name

    public List<QueryData> getQuestionsByTopicName(String name);
}
