package com.stackroute.botservice.service;

import com.stackroute.botservice.domain.UserQuery;
import com.stackroute.botservice.repository.QueryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryServiceImpl{


    private QueryRespository queryRespository;

    @Autowired
    public QueryServiceImpl(QueryRespository queryRespository) {
        this.queryRespository = queryRespository;
    }

    public UserQuery saveQuery(UserQuery userQuery) {
        UserQuery userQuery1;
        userQuery1 = (UserQuery) queryRespository.save(userQuery);
       return userQuery1;
    }
}
