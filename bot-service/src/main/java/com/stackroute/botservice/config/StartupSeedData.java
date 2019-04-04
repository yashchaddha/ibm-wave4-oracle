package com.stackroute.botservice.config;

import com.stackroute.botservice.domain.Same;
import com.stackroute.botservice.service.SameQueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/* Created on : 03/04/2019 by Subhajit Pal (@rahzex) */

/* Seed data from csv file, seeded into mongodb database every time on start up. */

@Component
class StartupSeedData implements ApplicationListener<ContextRefreshedEvent> {

    private SameQueryServiceImpl sameQueryServiceImpl;

    @Autowired
    public StartupSeedData(SameQueryServiceImpl sameQueryServiceImpl){
        this.sameQueryServiceImpl = sameQueryServiceImpl;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Same sameQandA = new Same();
        String line = "";
        Path filePath = Paths.get("data.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath.toUri()).getAbsolutePath()))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] quesAndAns = line.split(",");

                // initializing the "Same" object
                sameQandA.setId(quesAndAns[0]);
                sameQandA.setQuestion(quesAndAns[1]);

                StringBuilder answer = new StringBuilder();
                for(int i = 2; i < quesAndAns.length ;i++){
                    answer.append(quesAndAns[i]);
                }

                sameQandA.setAnswer(answer.toString());

                // saving initialized object into mongodb
                sameQueryServiceImpl.saveSameQuery(sameQandA);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
