package com.stackroute.manualservice.service;

import com.stackroute.manualservice.controller.ManualController;
import com.stackroute.manualservice.domain.Query;
import com.stackroute.manualservice.repository.ManualRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.*;

public class ManualServiceTests {


    private Query query;

    @Mock
    private ManualRepository manualRepository;

    @InjectMocks
    private ManualServiceImpl manualService;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        query = new Query();
        query.setQuestion("abcd");
        query.setId("1");
    }

    @Test
    public void testSaveQuestionSuccess(){

        when(manualRepository.save((Query) ArgumentMatchers.any())).thenReturn(query);
        Query savedQuery = manualService.saveQuestion(query);
        Assert.assertEquals(query,savedQuery);

        // Here we are verifying that userrepository save method is only called once
        verify(manualRepository,times(1)).save(query);
    }

}
