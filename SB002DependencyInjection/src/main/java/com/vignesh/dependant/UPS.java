package com.vignesh.dependant;

import org.springframework.stereotype.Component;

@Component(value = "ups")
public class UPS implements ICourier {

    private String name="Ups";
    @Override
    public String info() {
        return name;
    }
}
