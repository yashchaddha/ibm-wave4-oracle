package com.stackroute.graphqueryservice.service;

import com.stackroute.graphqueryservice.node.Concept;
import com.stackroute.graphqueryservice.repository.GraphQueryRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class GraphQueryServiceImpl implements GraphQueryService {

    private GraphQueryRepository graphQueryRepository;

    @Autowired
    public GraphQueryServiceImpl(GraphQueryRepository graphQueryRepository) {
        this.graphQueryRepository = graphQueryRepository;
    }

    @Override
    public Iterable<Concept> getAll()
    {
        return graphQueryRepository.findAll();
    }

}
