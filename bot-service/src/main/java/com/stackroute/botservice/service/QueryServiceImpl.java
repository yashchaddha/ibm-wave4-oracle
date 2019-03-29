package com.stackroute.botservice.service;

<<<<<<< HEAD:BotService/src/main/java/com/stackroute/BotService/service/QueryServiceImpl.java
import com.stackroute.BotService.domain.QueryData;
import com.stackroute.BotService.repository.QueryRespository;
=======
import com.stackroute.botservice.domain.QueryData;
import com.stackroute.botservice.repository.QueryRespository;
>>>>>>> 196c17920921902614a89c8ef8069e2edf773afd:bot-service/src/main/java/com/stackroute/botservice/service/QueryServiceImpl.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryServiceImpl{


    private QueryRespository queryRespository;

    @Autowired
    public QueryServiceImpl(QueryRespository queryRespository) {
        this.queryRespository = queryRespository;
    }

    public QueryData saveQuery(QueryData queryData) {
        QueryData queryData1;
       queryData1= (QueryData) queryRespository.save(queryData);
       return queryData1;
    }
}
