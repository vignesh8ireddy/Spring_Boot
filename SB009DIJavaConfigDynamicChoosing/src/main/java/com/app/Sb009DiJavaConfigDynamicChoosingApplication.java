package com.app;

import com.app.target.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.Arrays;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class Sb009DiJavaConfigDynamicChoosingApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Sb009DiJavaConfigDynamicChoosingApplication.class, args);
        System.out.println("Beans info are :: " + Arrays.toString(context.getBeanDefinitionNames()));
        System.out.println();
        Student student = context.getBean(Student.class);
        System.out.println(student);
        student.preparation(student.getMaterial().getClass().getName());
        ((ConfigurableApplicationContext) context).close();
    }

}