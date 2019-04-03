package com.stackroute.graphqueryservice.controller;

import com.stackroute.graphqueryservice.node.Concept;
import com.stackroute.graphqueryservice.service.GraphQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GraphQueryController {

    private GraphQueryService graphQueryService;

    @Autowired
    public GraphQueryController(GraphQueryService graphQueryService) {
        this.graphQueryService = graphQueryService;
    }

    @GetMapping("getall")
    public ResponseEntity<Iterable<Concept>> getAll(){
        return new ResponseEntity<>(graphQueryService.getAll(), HttpStatus.OK);
    }
}
