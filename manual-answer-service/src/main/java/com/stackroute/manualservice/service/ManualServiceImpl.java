package com.stackroute.manualservice.service;

import com.stackroute.manualservice.Domain.QueryData;
import com.stackroute.manualservice.repository.ManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManualServiceImpl implements ManualService{

    private ManualRepository manualRepository;


    @Autowired
    public ManualServiceImpl(ManualRepository manualRepository) {

        this.manualRepository = manualRepository;
    }

    // Implemeneting Methods

    //1. Save user method

    @Override
    public QueryData saveUser(QueryData userQuery) {
        System.out.println("********" + userQuery);

        QueryData query = manualRepository.save(userQuery);
        return  query;

    }

    // 2. Get list of query
    @Override
    public List<QueryData> getListOfQuery() {

        List<QueryData> userQueryList = (List<QueryData>) manualRepository.findAll();

        return userQueryList;
    }

    //3. Update Query

    @Override
    public QueryData updateQuery(QueryData userQuery, String  queryId) {

        Boolean isUserWithIDExists = manualRepository.existsById(queryId);

        if (isUserWithIDExists) {
            QueryData updateUser = (QueryData) manualRepository.findById(queryId).get();
            updateUser.setQuestion(userQuery.getQuestion());
            updateUser.setAnswer(userQuery.getAnswer());
            updateUser.setStatus(updateUser.getStatus());

            return manualRepository.save(updateUser);
        } else {
            return  null;
        }
    }

    // 4. Delete The user Query

    @Override
    public QueryData deleteQuery(String queryId) {
        QueryData deletedQuery = (QueryData) manualRepository.findById(queryId).get();
        manualRepository.deleteById(queryId);
        return deletedQuery;
    }
}
