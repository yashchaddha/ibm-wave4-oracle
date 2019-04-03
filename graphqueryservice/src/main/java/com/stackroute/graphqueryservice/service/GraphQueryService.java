package com.stackroute.graphqueryservice.service;

import com.stackroute.graphqueryservice.node.Concept;
import org.springframework.stereotype.Service;

@Service
public interface GraphQueryService {
    Iterable<Concept> getAll();
}
