package com.stackroute.botservice.controller;


import com.stackroute.botservice.domain.UserQuery;
import com.stackroute.botservice.service.QueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class BotController {


    KafkaTemplate<Object,Object> kafkaTemplate;


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
        UserQuery userQuery1 =null;
        userQuery1 = queryService.saveQuery(userQuery);
            kafkaTemplate.send("new_query", userQuery1.getQuery());
            return new ResponseEntity<UserQuery>(userQuery1, HttpStatus.CREATED);

    }

}
