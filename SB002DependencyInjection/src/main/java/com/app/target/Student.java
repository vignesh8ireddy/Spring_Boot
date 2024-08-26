package com.app.target;

import com.app.dependant.ICourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@Component(value = "student")
public class Student {

    @Autowired
    //@Qualifier("java"), instead you can also use below way using xml configuration
    @Qualifier("courseId")
    public ICourse Course;

    public void info() {
        System.out.println("Student is currently learning "+Course.courseContent()+" with price "+Course.coursePrice());
    }

}
