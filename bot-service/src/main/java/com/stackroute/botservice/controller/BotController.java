package com.stackroute.botservice.controller;


import com.mongodb.util.JSON;
import com.stackroute.botservice.domain.Query;
import com.stackroute.botservice.domain.UserQuery;
import com.stackroute.botservice.service.QueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class BotController {


    KafkaTemplate<Object, Object> kafkaTemplate;


    private QueryServiceImpl queryService;

    public BotController() {
    }

    @Autowired
    public BotController(KafkaTemplate<Object, Object> kafkaTemplate, QueryServiceImpl queryService) {
        this.kafkaTemplate = kafkaTemplate;
        this.queryService = queryService;
    }


    @PostMapping("/send/query")
    public ResponseEntity<?> sendNewQuery(@RequestBody UserQuery userQuery) {

        Query questionQuery = userQuery.getQuery();
        RestTemplate restTemplate = new RestTemplate();
        String correctedQuery = restTemplate.getForObject("http://localhost:8595/api/v1/getCorrectedQuery/" + questionQuery.getQuestion(), String.class);
        questionQuery.setQuestion(correctedQuery);
        userQuery.setQuery(questionQuery);
        userQuery = queryService.saveQuery(userQuery);
        kafkaTemplate.send("new_query", userQuery.getQuery());
        userQuery.getStatus().setAnswered(true);
        userQuery.getQuery().setAnswer("i will tell u later either ask aman");
        return new ResponseEntity<UserQuery>(userQuery, HttpStatus.CREATED);

    }
}
