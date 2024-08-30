package com.app;

import com.app.components.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Sb006CollectionInjectionYmlApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Sb006CollectionInjectionYmlApplication.class, args);
		Employee employee = context.getBean(Employee.class);
		System.out.println(employee);

		((ConfigurableApplicationContext) context).close();
	}
}

/*
YML/YAML Injection
==================
	> It stands for Yet Another MarkUp Language.
	> The extension of the file is .yml or .yaml
	> The biggest limitation of properties file is nodes/level will be repeated in mulitple
	keys, especially while working with common prefix concepts like collection,HAS-A property to support
	bulk injection using @ConfigurationProperties.
	> SpringFramework doesnot support yml file/where as SpringBoot support yml injection
	> SpringBoot framework internally use snakeyml<ver>.jar for processing the yml file.

Rules while writing yml file
============================
	> same nodes/level in the key should not be duplicated
	> replace "." of each node/level with ":" and write new node in next line with proper
	indentation(minimum single space is required)
	> replace "=" symbol with ":" before placing value having minimum single space.
	> To replace Array,List,Set elements use "-".
	> Take Map collection keys and HAS-A property subkeys as the new nodes/levels.
	> use #symbol for Commenting.
 */