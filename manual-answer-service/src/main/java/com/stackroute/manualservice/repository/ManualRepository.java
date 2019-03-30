package com.stackroute.manualservice.repository;

import com.stackroute.manualservice.domain.QueryData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManualRepository extends MongoRepository<QueryData,String> {

    @Query("{ 'question' : ?0 }")
    List<QueryData> searchByName(String name);

}
