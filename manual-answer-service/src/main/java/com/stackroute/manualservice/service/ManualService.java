package com.stackroute.manualservice.service;

import com.stackroute.manualservice.domain.UserQuery;

import java.util.List;

public interface ManualService {

    //Save user
    public UserQuery saveUser(UserQuery userQuery);

    //get List of UserQuery
    public List<UserQuery> getListOfQuery();


    //Update User
    public UserQuery updateQuery(UserQuery user, String queryId);

    //Delete User
    public UserQuery deleteQuery(String queryId);

}
