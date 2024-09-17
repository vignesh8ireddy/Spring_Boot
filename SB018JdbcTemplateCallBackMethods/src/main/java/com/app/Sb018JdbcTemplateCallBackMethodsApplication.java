package com.app;

import com.app.dto.StudentDTO;
import com.app.service.IStudentMgmtService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Sb018JdbcTemplateCallBackMethodsApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication
                .run(Sb018JdbcTemplateCallBackMethodsApplication.class, args);

        IStudentMgmtService service = applicationContext.getBean(IStudentMgmtService.class);



        List<StudentDTO> list = service.fetchStudentByName("veen","rohan");
        list.forEach(System.out::println);

        ((ConfigurableApplicationContext) applicationContext).close();

    }

}

/*

JdbcTemplate with CallBackInterfaces
====================================
1.RowMapper<T>
2.ResultSetExtractor
3.RowCallBackHandle

*/
