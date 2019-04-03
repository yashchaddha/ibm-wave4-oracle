package com.stackroute.graphqueryservice.node;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;


@NodeEntity(label = "Concept")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Concept {

    @Id
    @GeneratedValue
    private Long graphId;

    private String id;
    private String name;
    private String parentid;
    private String parentname;
    private String type;
    private String relation;

    @Relationship(type = "QUESTION_OF",direction = "INCOMING")
    private List<Questions> questionsList;
}

