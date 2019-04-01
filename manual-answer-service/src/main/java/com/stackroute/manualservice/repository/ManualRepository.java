package com.stackroute.manualservice.repository;


import com.stackroute.manualservice.domain.UserQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManualRepository extends MongoRepository<UserQuery,String> {

    @org.springframework.data.mongodb.repository.Query("{ 'question' : ?0 }")
    List<UserQuery> searchByName(String name);

}
