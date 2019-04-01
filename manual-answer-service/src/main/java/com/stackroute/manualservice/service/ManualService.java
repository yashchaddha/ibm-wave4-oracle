package com.stackroute.manualservice.service;

import com.stackroute.manualservice.domain.UserQuery;
import com.stackroute.manualservice.exception.QueryNotFoundException;

import java.util.List;

public interface ManualService {

    //Save user
    public UserQuery saveQuestion(UserQuery userQuery);

    //get List of Question
    public List<UserQuery> getListOfQuestions();


    //Update UserQuery
    public UserQuery updateQuestion(UserQuery userQuery) throws QueryNotFoundException;

    //Delete UserQuery
    public UserQuery deleteQuestion(String queryId);


    //Get UserQuery by Topic name

    public List<UserQuery> getQuestionsByTopicName(String name);
}
