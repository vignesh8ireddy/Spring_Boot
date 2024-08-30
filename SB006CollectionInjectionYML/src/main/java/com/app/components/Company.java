package com.app.components;

import org.springframework.stereotype.Component;

@Component("company")
public class Company {
    private String name;
    private String location;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Company [name=" + name + ", location=" + location + ", type=" + type + "]";
    }

}
