package com.springboot001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication //this itself is the configuration file
public class Springboot001Application {

    static {
        System.out.println("SpringBootApplication's .class file is loaded.");
    }

    public Springboot001Application() {
        System.out.println("SpringBootApplication class' Zero Parameter Constructor is called.");
    }

    @Bean(name = "ldt")
    public LocalDateTime createLocalDateTimeBean() {
        LocalDateTime ldt = LocalDateTime.now();
        return ldt;
    }

    public static void main(String[] args) {
        //this line itself starts the IOC container, you don't have to do it manually
        //SpringApplication.run(Springboot001Application.class, args);


        ApplicationContext context = SpringApplication.run(Springboot001Application.class, args);
        System.out.println(context.getClass().getName());//AnnotationConfigApplicationContext

        System.out.println("*****IOC Container Started*****");

        WishMessageGenerator beanWMG = context.getBean(WishMessageGenerator.class);
        beanWMG.generateWishMessage();

        ((ConfigurableApplicationContext) context).close();

        System.out.println("*****IOC Container Stopped*****");
    }

}


/*
JAR files are used for standalone Applications
WAR files are used for Web Applications

STEPS:
=====
1. SpringApplication.run() this takes springbootapplication.class file as argument which is configuration file
    > IOC Container (named ApplicationContext) created and started
2. IOC Container searches for stereotype annotations (WishMessageGenerator component) in src package and subpackages
3. Creates Objects for the components of singleton scope (WishMessageGenerator component).
4. Comes back to springbootapplication class file and searches for localdatatime bean, creates an object as bean and
    initializes the component reference to this bean as autowiring
5. Now stores all the beans and their references as key-value pairs in the internal cache
    ldt: LocalDateTime obj
    beanWMG: WishMessageGenerator obj
    context: Springboot001Application obj
6. Default scope of all beans is 'singleton'
   That is the reason wishmessagegenerator class is loaded when the container is started
   If the scope is prototype wishmessagegenerator class is loaded at context.getBean() and then autowiring would be done

IMPORTANT POINTS
================
@SpringBootApplication includes all following three:
    @EnableAutoConfiguration(It enables AutoConfiguration)
    @ComponentScan(Scan for the stereo type annotations in the given package and subpackage)
    @Configuration(Marking the class as Configuration class)

SpringApplication.run() internally uses AnnotationConfigApplicationContext class to create an IOC container

Difference b/w Spring vs SpringBoot
===================================
1. Spring
    > It is a framework for JEE technologies/Application framework
    > The main feature is Dependency Injection and Dependency LookUp.
    > It supports XML driven configuration as a inputs to the IOC-Container.
    > Programmer creates IOC container explicitly.
    > Allows to develop spring apps using
        a. XML
        b. XML + Annotation
        c. Pure Java(No XML)
    > Doesn't give embedded server to use in web applications.
    > Doesn't give embedded database/inMemory Database
    > It is light weight because no autoconfiguration.
    > No support for "Microservices architecture" based application development.
2. SpringBoot
    > It provides abstraction for Spring framework and simplifies SpringApp development.
    > The main feature is AutoConfiguration(giving common things automatically)
    > Doesn't support XML driven configuration as a inputs to the IOC-Container.
    > Programmer doesn't create IOC container explicitly it gets created automatically using
      SpringApplication.run().
    > Supports only one style of configuration that is AutoConfiguration where inputs are supplied
      through application.properties/.yml file.
    > It gives embedded server(tomcat server,jetty server) to use in web applications.
    > It gives embedded database/InMemory database called "H2".
    > It is heavy weight because of AutoConfiguration.
    > Support of Microservices architecture is extensively available.

 */