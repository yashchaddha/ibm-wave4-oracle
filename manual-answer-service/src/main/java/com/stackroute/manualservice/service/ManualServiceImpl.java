package com.stackroute.manualservice.service;

import com.stackroute.manualservice.domain.UserQuery;
import com.stackroute.manualservice.exception.QueryNotFoundException;
import com.stackroute.manualservice.repository.ManualRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManualServiceImpl implements ManualService {

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
    public UserQuery saveQuestion(UserQuery userQuery) {
        logger.info("Save User:" + userQuery);

        UserQuery saveUserQuery = manualRepository.save(userQuery);
        return userQuery;

    }

    // 2. Get list of questions
    @Override
    public List<UserQuery> getListOfQuestions() {

        List<UserQuery> userUserQueryList = (List<UserQuery>) manualRepository.findAll();

        return userUserQueryList;
    }

    //3. Update Question

    @Override
    public UserQuery updateQuestion(UserQuery userQuery) throws QueryNotFoundException {


        if (manualRepository.existsById(userQuery.getId())) {

            return manualRepository.save(userQuery);

        }
        else {
            throw new QueryNotFoundException("Query Not Found");
        }
    }

    // 4. Delete The user Question

    @Override
    public UserQuery deleteQuestion(String questionId) {
        UserQuery deletedQuery = (UserQuery) manualRepository.findById(questionId).get();
        manualRepository.deleteById(questionId);
        return deletedQuery;
    }


    //5.Get UserQuery by Topic name

    @Override
    public List<UserQuery> getQuestionsByTopicName(String name) {

        List<UserQuery> userQueryList = manualRepository.searchByName(name);
        return userQueryList;
    }

}
