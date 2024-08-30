package com.app.components;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component(value="company2")
@ConfigurationProperties(prefix="org.company2")
public class Company2 {
    private String name;
    private String location;
    private String type;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        System.out.println("setLocation()");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("setName()");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        System.out.println("setType()");
    }

    public String toString() {
        return name+", "+location+", "+type ;
    }
}
