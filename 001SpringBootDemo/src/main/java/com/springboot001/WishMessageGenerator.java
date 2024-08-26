package com.springboot001;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component(value="wmg")
public class WishMessageGenerator {

    @Autowired
    private LocalDateTime date;

    static {
        System.out.println("WishMessageGenerator.class is loaded.");
    }

    public WishMessageGenerator() {
        System.out.println("WishMessageGenerator Zero Parameter Constructor is called.");
    }

    //business logic
    public void generateWishMessage() {
        System.out.println("WishMessageGenerator.generateWishMessage() is called.");
        int hour = date.getHour();
        if(hour<12) {
            System.out.println("Good Morning!");
        }
        else if(hour<16) {
            System.out.println("Good Afternoon");
        }
        else if(hour<20) {
            System.out.println("Good Evening");
        }
        else {
            System.out.println("Good night");
        }

    }

}

