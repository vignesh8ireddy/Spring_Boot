package com.app.dependant;

import org.springframework.stereotype.Component;

@Component(value = "java")
public final class JavaCourse implements ICourse {

    @Override
    public String courseContent() {
        return "1. Java Standard Edition 2. Java Enterprise Edition";
    }

    @Override
    public double coursePrice() {
        return 2500;
    }
}
