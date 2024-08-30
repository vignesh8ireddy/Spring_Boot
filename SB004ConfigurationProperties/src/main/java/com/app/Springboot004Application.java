package com.app;

import com.app.components.Company;
import com.app.components.Company2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot004Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Springboot004Application.class, args);
		Company cBean = context.getBean("company", Company.class);
		System.out.println(cBean);
		Company2 c2Bean = context.getBean("company2", Company2.class);
		System.out.println(c2Bean);
		((ConfigurableApplicationContext) context).close();
	}


}

/*

There are 2 different ways to perform injection to spring bean properties
a. @Value => It can be used to inject each value to spring bean properties
b. @ConfigurationProperties => It can be used to perform bulk injection.

@ConfigurationProperties internally uses setter methods to inject values from properties file
without setter methods this injection would not happen

If you wanna store the property values in some other file say input.properties other than application.properties
you have to use @PropertySource(value="com/app/..../input.properties")

What is the difference b/w @Value and @CofigurationProperties?
@Value
	> It is given by Spring framework,so it can be used in Spring and SpringBoot applications.
	> Support single value injection to Spring bean property.
	> It performs field level injection(setters not required)
	> Common prefix of all keys are not required in application.properties/application.yml file
	> Keys in properties file and property names need not match.
	> If specified key is not present then it would result in "IllegalArgumentException".
@ConfigurationProperties
	> It is given by SpringBoot framework,so it can be used only SpringBoot applications.
	> Support bulk operation
	> It perform setter level injection internally, so setters are mandatory
	> Common prefix of all keys are required in application.properties/application.yml file.
	> keys in properties file and property names should match
	> If the matching key is not found then it would neglect the injection.

Note: While working with @ConfigurationProperties, it is always suggested to add
configuarationProcessor inside pom.xml file
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-configuration-processor</artifactId>
<optional>true</optional>
</dependency>

Note: If we try to inject different values to spring bean property using both
Fieldlevel(@value) and @ConfigurationProperties annotations, which one will be
injection?
Answer: Since @ConfigurationProperties uses setter injection,so the values
injected at field level(@Value) will be overridden with Setter level

List of Annotations
===================
1. @Component
2. @ComponentScan
3. @Service
4. @Repository
5. @Controller
6. @Bean
7. @Qualifier
8. @Primary
9. @Lazy
10. @Scope
11. @PostConstruct
12. @PreDestroy
13. @Autowired
14. @Value
15. @Configuration
16. @Import
17. @ImportResource
18. @PropertySource

 */