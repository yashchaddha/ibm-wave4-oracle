package com.stackroute.botservice.service;

import com.stackroute.botservice.domain.Same;
import com.stackroute.botservice.repository.SameQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SameQueryServiceImpl {

    private SameQueryRepository sameQueryRepository;

    @Autowired
    public SameQueryServiceImpl(SameQueryRepository sameQueryRespository) {
        this.sameQueryRepository = sameQueryRespository;
    }

    public Same saveSameQuery(Same sameQuery) {
        return sameQueryRepository.save(sameQuery);
    }
}
