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

@NodeEntity(label = "Questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Questions {

    @Id
    @GeneratedValue
    private Long graphId;

    private String id;
    private String name;
    private String questionparentid;
    private String concept;

    @Relationship(type = "ANSWER_OF",direction = "INCOMING")
    private List<Answer> answerList;
}
