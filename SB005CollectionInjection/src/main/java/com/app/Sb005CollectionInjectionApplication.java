package com.app;

import com.app.components.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Sb005CollectionInjectionApplication {

	public static void main(String[] args) {
	ApplicationContext context = SpringApplication.run(Sb005CollectionInjectionApplication.class, args);
	Employee empBean = context.getBean(Employee.class);
	System.out.println(empBean);
	}

}
