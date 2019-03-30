package com.stackroute.manualservice.controller;

import com.stackroute.manualservice.domain.QueryData;
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
    public ResponseEntity<List<QueryData>> getAllQuestions() {

        List<QueryData> questionList = manualService.getListOfQuestions();
        return new ResponseEntity<List<QueryData>>(questionList, HttpStatus.OK);

    }

//Delete Request

    @PostMapping("/updateQuestion")
    public ResponseEntity<String> updateQuestion(@RequestBody QueryData queryData) {

        QueryData updateQuestion = manualService.updateQuestion(queryData);

        logger.info("Updated Questions:" + updateQuestion);

        // send data back to the bot service
        kafkaTemplate.send("update_query",updateQuestion);

        //Delete the data from consumer side
        manualService.deleteQuestion(updateQuestion.getId());

        return new ResponseEntity<String>("Question Deleted Successfully", HttpStatus.OK);
    }

}
