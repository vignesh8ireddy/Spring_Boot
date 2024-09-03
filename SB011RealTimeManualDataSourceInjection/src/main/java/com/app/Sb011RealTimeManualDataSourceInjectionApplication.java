package com.app;

import com.app.components.IEmployeeDAO;
import com.app.dto.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, JdbcTemplateAutoConfiguration.class })
public class Sb011RealTimeManualDataSourceInjectionApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Sb011RealTimeManualDataSourceInjectionApplication.class, args);
        IEmployeeDAO dao = context.getBean(IEmployeeDAO.class);
        try {
            List<Employee> employees = dao.findAllEmployees();
            employees.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ((ConfigurableApplicationContext) context).close();
    }

}


/*

Can we disable autoconfiguration of certain spring bean even though starters are added?
Ans. yes,we can do by using exclude param

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
                                JdbcTemplateAutoConfiguration.class })

public class Sb011RealTimeManualDataSourceInjectionApplication {
public static void main(String[] args) {

;;;;;

}
}

In the above case we need to use @Bean method to create ur choice class objects and
to make them as spring bean either in @Configuration class or in @SpringBootApplication class.

@Configuration
public class PersistConfig {

@Autowired
private Environment env;

@Bean
public ComboPooledDataSource createDS() throws Exception {
System.out.println("PersistConfig.createDS()");
ComboPooledDataSource dataSource = new ComboPooledDataSource();
dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
dataSource.setUser(env.getProperty("spring.datasource.username"));
dataSource.setPassword(env.getProperty("spring.datasource.password"));
return dataSource;
}
}


pom.xml
======
<dependency>
<groupId>com.mchange</groupId>
<artifactId>c3p0</artifactId>
<version>0.9.5.4</version>
</dependency>

 */