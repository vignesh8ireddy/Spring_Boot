package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Sb015RunnersApplication {

    public static void main(String[] args) {
        System.out.println("****Container started****");
        ApplicationContext applicationContext = SpringApplication.run(Sb015RunnersApplication.class, args);

        System.out.println("****Container stopped*****");
        ((ConfigurableApplicationContext) applicationContext).close();
    }

}


/*

Runners in springboot
=====================

> Runners are java classes which would act like Spring bean of SpringBoot which
  are implement in XxxxRunners directly or indirectly.
> Every runner class contains run() dealing with onetime executing logic and those
  logics will execute where SpringApplication.run() is about to complete all its startup
  activities(right after creating a ApplicationContext object and completing preinstantiation
  and injections)
> The run() of every Runner class will be executed automatically by IOC container only for
  one time as a part of ApplicationStartup process that takes place in SpringApplication.run() method.

There are 2 types of Runners in SpringBoot
a. CommandLineRunner(I)
b. ApplicationRunner(I)

Note: Both the runner are giving run() as the callback method[becoz it get called by
underlying IOC container automatically]

Both the runner run() method gets the command line arguments as the parameter
values but the way they get them is different.

 */