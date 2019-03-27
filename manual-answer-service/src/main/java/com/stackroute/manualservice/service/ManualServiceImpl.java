package com.stackroute.manualservice.service;

import com.stackroute.manualservice.domain.UserQuery;
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
    public UserQuery saveUser(UserQuery userQuery) {

        UserQuery query = manualRepository.save(userQuery);
        return  query;

    }

    // 2. Get list of query
    @Override
    public List<UserQuery> getListOfQuery() {

        List<UserQuery> userQueryList = (List<UserQuery>) manualRepository.findAll();

        return userQueryList;
    }

    //3. Update Query

    @Override
    public UserQuery updateQuery(UserQuery userQuery, String  queryId) {

        Boolean isUserWithIDExists = manualRepository.existsById(queryId);

        if (isUserWithIDExists) {
            UserQuery updateUser = (UserQuery) manualRepository.findById(queryId).get();
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
    public UserQuery deleteQuery(String queryId) {
        UserQuery deletedQuery = (UserQuery) manualRepository.findById(queryId).get();
        manualRepository.deleteById(queryId);
        return deletedQuery;
    }
}
