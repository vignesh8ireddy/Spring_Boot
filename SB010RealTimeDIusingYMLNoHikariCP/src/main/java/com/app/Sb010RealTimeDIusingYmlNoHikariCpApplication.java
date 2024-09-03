package com.app;

import com.app.components.IEmployeeDAO;
import com.app.dto.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Sb010RealTimeDIusingYmlNoHikariCpApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Sb010RealTimeDIusingYmlNoHikariCpApplication.class, args);

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

Note: As of Springboot 2.5+ version is using three Datasources as a part of
AutoConfiguration if we add spring-boot-starter-jdbc
a. hikari cp(default)
b. Apache dbcp2 datasource(only when hikaricp jars are not there in the
classpath)
c. tomcat-dbc(only when hikaricp jars are not there in the classpath)

Priority order for AutoConfiguration is
a. hikaricp(best choice)
b. tomcat
c. dbcp2

commons DBCP2
============
<dependency>
<groupId>org.apache.commons</groupId>
<artifactId>commons-dbcp2</artifactId>
</dependency>

tomcat jdbc
============
<!-- https://mvnrepository.com/artifact/org.apache.tomcat/tomcat-jdbc -->
<dependency>
<groupId>org.apache.tomcat</groupId>
<artifactId>tomcat-jdbc</artifactId>
</dependency>

How can we make dbcp2 datasource to work with SpringBoot?
=> exclude hikaricp jar file from dependent jar of "spring-boot-starter-jdbc"


pom.xml
=======
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-jdbc</artifactId>
<exclusions>
<exclusion>
<groupId>com.zaxxer</groupId>
<artifactId>HikariCP</artifactId> ====> go to dependancy

hierarchy tab(right click on hikaricp ,exclude maven artifact)

</exclusion>
</exclusions>
</dependency>

Add apachedbcp2 jar files

pom.xml
=======
<dependency>
<groupId>org.apache.commons</groupId>
<artifactId>commons-dbcp2</artifactId>
</dependency>


 */