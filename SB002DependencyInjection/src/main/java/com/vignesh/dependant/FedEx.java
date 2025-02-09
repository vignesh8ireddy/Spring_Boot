package com.vignesh.dependant;

import org.springframework.stereotype.Component;

@Component(value = "fedex")
public class FedEx implements ICourier {

    private String name = "FedEx";
    @Override
    public String info() {
        return name;
    }
}
