package com.app.dependant;

import org.springframework.stereotype.Component;

@Component(value = "dotnet")
public class DotNetCourse implements ICourse {

    @Override
    public String courseContent() {
        return "1. Core .Net 2. Advanced .Net";
    }

    @Override
    public double coursePrice() {
        return 1500;
    }
}
