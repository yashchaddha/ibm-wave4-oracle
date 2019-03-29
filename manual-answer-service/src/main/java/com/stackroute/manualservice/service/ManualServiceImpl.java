package com.stackroute.manualservice.service;

import com.stackroute.manualservice.domain.QueryData;
import com.stackroute.manualservice.repository.ManualRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManualServiceImpl implements ManualService{

    private ManualRepository manualRepository;

    //Declaration

    private final Logger logger = LoggerFactory.getLogger(ManualServiceImpl.class);

    @Autowired
    public ManualServiceImpl(ManualRepository manualRepository) {

        this.manualRepository = manualRepository;
    }

    // Implemeneting Methods

    //1. Save user method

    @Override
    public QueryData saveUser(QueryData userQuery) {
        logger.info("Save User:" + userQuery);

        QueryData query = manualRepository.save(userQuery);
        return  query;

    }

    // 2. Get list of questions
    @Override
    public List<QueryData> getListOfQuestions() {

        List<QueryData> userQueryList = (List<QueryData>) manualRepository.findAll();

        return userQueryList;
    }

    //3. Update Query

    @Override
    public QueryData updateQuestion(QueryData userQuery) {

        String queryId = userQuery.getId();
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
    public QueryData deleteQuestion(String queryId) {
        QueryData deletedQuery = (QueryData) manualRepository.findById(queryId).get();
        manualRepository.deleteById(queryId);
        return deletedQuery;
    }


    //5.Get Question by Topic name

    @Override
    public List<QueryData> getQuestionsByTopicName(String name)  {

        List<QueryData> questionList = manualRepository.searchByName(name);
        return questionList;
    }

}
