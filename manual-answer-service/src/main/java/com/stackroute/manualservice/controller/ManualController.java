package com.stackroute.manualservice.controller;

import com.stackroute.manualservice.domain.UserQuery;
import com.stackroute.manualservice.service.ManualService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class ManualController {

    //Declaration

    private ManualService manualService;
    private KafkaTemplate<Object,Object> kafkaTemplate;

    private final Logger logger = LoggerFactory.getLogger(ManualController.class);

    @Autowired
    public ManualController(ManualService manualService, KafkaTemplate<Object, Object> kafkaTemplate) {
        this.manualService = manualService;
        this.kafkaTemplate = kafkaTemplate;
    }


    // Get  Request for getting all the questions

    @GetMapping("/getAllQuestions")
    public ResponseEntity<List<UserQuery>> getAllQuestions() {

        List<UserQuery> questionList = manualService.getListOfQuestions();

        return new ResponseEntity<List<UserQuery>>(questionList, HttpStatus.OK);

    }

//Delete Request

    @PostMapping("/updateQuestion")
    public ResponseEntity<String> updateQuestion(@RequestBody UserQuery question, @RequestBody String Answer) {

        Question updateQuestion = manualService.updateQuestion(question,Answer);

        logger.info("Updated Questions:" + updateQuestion);

        // send data back to the bot service
        kafkaTemplate.send("update_query",updateQuestion);

        //Delete that quedstion from Consumer side
        manualService.deleteQuestion(question.getId());

        return new ResponseEntity<String>("UserQuery Deleted Successfully", HttpStatus.OK);
    }
}
