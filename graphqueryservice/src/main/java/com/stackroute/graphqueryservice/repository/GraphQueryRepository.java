package com.stackroute.graphqueryservice.repository;

import com.stackroute.graphqueryservice.node.Concept;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphQueryRepository extends Neo4jRepository<Concept,Long> {

}