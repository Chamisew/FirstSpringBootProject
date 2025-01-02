package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class TennisCoach implements Coach{
    public TennisCoach() {

        System.out.println("In constructor:"+getClass().getSimpleName());

    }

    //define init method
    @PostConstruct
    public void doMyStartUpStuff(){
        System.out.println("In doMyStartUpStuff():"+getClass().getSimpleName());
    }

    //define our destroy
    @PreDestroy
    public void doMyCleanUpStuff(){
        System.out.println("In doMyCleanUpStuff():"+getClass().getSimpleName());
    }




    @Override
    public String getDailyWorkout() {

        return "Practice your backend volley";
    }
}
