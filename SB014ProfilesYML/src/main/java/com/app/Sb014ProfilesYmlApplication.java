package com.app;

import com.app.controller.EmployeeController;
import com.app.vo.EmployeeVO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Sb014ProfilesYmlApplication {

    @SuppressWarnings("resource")
    public static void main(String[] args){

        ApplicationContext context = SpringApplication.run(Sb014ProfilesYmlApplication.class, args);

        System.out.println(context);
        System.out.println("No of beans is :: " + Arrays.toString(context.getBeanDefinitionNames()));

        // read inputs from enduser
        Scanner sc = new Scanner(System.in);
        System.out.print("Desgs count:: ");
        int count = sc.nextInt();
        String desgs[] = null;
        if (count >= 1)
            desgs = new String[count];
        else {
            System.out.println("invalid desgn count ");
            return;
        }
        for (int i = 0; i < count; ++i) {
            System.out.print("enter desg" + (i + 1) + ":: ");
            String desg = sc.next();
            desgs[i] = desg;
        }

        // get Controller class obj
        EmployeeController controller = context.getBean("empController", EmployeeController.class);

        // invoke business method
        try {
            List<EmployeeVO> listVO = controller.showEmpsByDesgs(desgs);
            System.out.println("Emp details having " + Arrays.toString(desgs));
            listVO.forEach(vo -> {
                System.out.println(vo);
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some Internal problem::" + e.getMessage());
        }

        // close IOC container
        ((ConfigurableApplicationContext) context).close();
        sc.close();
    }

}


/* single application.yml file

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    password: root123
    url: jdbc:mysql:///enterprisejavabatch
    username: root
  profiles:
    active: default

---
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    password: root123
    url: jdbc:mysql:///enterprisejavabatch
    username: root
  config:
    activate:
      on-profile: dev
---
spring:
  datasource:
    driver-class-name: oracle.jdbc.driver.OracleDriver
    password: root123
    url: jdbc:oracle:thin:@localhost:1521:XE
    username: System
  config:
    activate:
      on-profile: test
---
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    password: root123
    type: org.apache.commons.dbcp2.BasicDataSource
    url: jdbc:mysql:///enterprisejavabatch
    username: root
  config:
    activate:
      on-profile: uat
---

spring:
  datasource:
    driver-class-name: oracle.jdbc.driver.OracleDriver
    password: root123
    url: jdbc:oracle:thin:@localhost:1521:XE
    username: System
  config:
    activate:
      on-profile: prod

 */