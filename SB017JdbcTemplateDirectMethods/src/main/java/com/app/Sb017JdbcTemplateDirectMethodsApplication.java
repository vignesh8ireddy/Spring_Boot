package com.app;

import com.app.service.IEmployeeMangementService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Sb017JdbcTemplateDirectMethodsApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Sb017JdbcTemplateDirectMethodsApplication.class, args);

        IEmployeeMangementService service = applicationContext.getBean(IEmployeeMangementService.class);
        List<Map<String, Object>> employeeDeatilsByDesignation = service.getEmployeeDeatilsByDesignation("bowler",
                "king");
        employeeDeatilsByDesignation.forEach(System.out::println);

        ((ConfigurableApplicationContext) applicationContext).close();

    }

}
