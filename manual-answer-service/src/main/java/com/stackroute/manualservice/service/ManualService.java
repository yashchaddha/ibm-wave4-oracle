package com.stackroute.manualservice.service;

import com.stackroute.manualservice.Domain.QueryData;

import java.util.List;

public interface ManualService {

    //Save user
    public QueryData saveUser(QueryData userQuery);

    //get List of QueryData
    public List<QueryData> getListOfQuery();


    //Update User
    public QueryData updateQuery(QueryData user, String queryId);

    //Delete User
    public QueryData deleteQuery(String queryId);

}
