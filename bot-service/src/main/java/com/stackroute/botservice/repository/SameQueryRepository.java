package com.stackroute.botservice.repository;

import com.stackroute.botservice.domain.Same;
import org.springframework.data.mongodb.repository.MongoRepository;

/* Created on : 03/04/2019 by Subhajit Pal (@rahzex) */

public interface SameQueryRepository extends MongoRepository<Same, String> {
}
