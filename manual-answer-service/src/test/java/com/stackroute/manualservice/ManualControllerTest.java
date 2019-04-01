package com.stackroute.manualservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.manualservice.controller.ManualController;
import com.stackroute.manualservice.domain.Query;
import com.stackroute.manualservice.repository.ManualRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ManualControllerTest {

    private Query query;

    @Mock
    private ManualRepository manualRepository;

    @InjectMocks
    private ManualController manualController;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void Setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(manualController).build();
        query = new Query();
        query.setQuestion("This is my question");
    }


    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }


}
