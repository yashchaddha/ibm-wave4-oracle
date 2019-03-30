package com.stackroute.manualservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class StatusData {
    @Id
    int statusId;
    Boolean answered;
    Boolean accepted;

}
