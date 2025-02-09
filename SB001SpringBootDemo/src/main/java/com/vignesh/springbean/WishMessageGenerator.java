package com.vignesh.springbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component(value="wmg")
public class WishMessageGenerator {

    @Autowired
    private LocalDateTime date;

    //business logic
    public String generateWishMessage() {
        int hour = date.getHour();
        if(hour<12) {
            return "Good Morning!";
        }
        else if(hour<16) {
            return "Good Afternoon!";
        }
        else if(hour<18) {
            return "Good Evening!";
        }
        else {
            return "Good Night!";
        }

    }

}

