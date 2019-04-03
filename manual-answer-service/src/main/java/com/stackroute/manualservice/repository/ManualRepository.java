package com.stackroute.manualservice.repository;


import com.stackroute.manualservice.domain.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManualRepository extends MongoRepository<Query,String> {

    @org.springframework.data.mongodb.repository.Query("{ 'question' : ?0 }")
    List<Query> searchByName(String name);

}
