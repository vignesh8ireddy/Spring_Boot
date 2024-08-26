package com.app;//IOC Container searches only this package and its subpackages for components

import com.app.target.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath:configuration/applicationContext.xml")
public class Springboot002Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Springboot002Application.class, args);
		Student sBean = context.getBean("student", Student.class);
		sBean.info();

	}

}
