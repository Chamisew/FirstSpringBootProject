package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowlling for 15 minutes :-) ";
    }
}
