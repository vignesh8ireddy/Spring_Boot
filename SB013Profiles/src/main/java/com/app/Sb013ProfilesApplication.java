package com.app;

import com.app.controller.EmployeeController;
import com.app.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Sb013ProfilesApplication {

    static {
        System.out.println("Sb013ProfilesApplication.class file is loading...");
    }

    public Sb013ProfilesApplication() {
        System.out.println("Sb013ProfilesApplication:: Zero param constructor...");
    }

    @Autowired
    private Environment env;

/*    @Bean(name = "dataSource")
    @Profile({"dev","uat"})
    public ComboPooledDataSource createDS() throws Exception {
        System.out.println("Sb013ProfilesApplication");
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUser(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }*/

    @SuppressWarnings("resource")
    public static void main(String[] args){

        ApplicationContext context = SpringApplication.run(Sb013ProfilesApplication.class, args);

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

/*

Profiles in SpringBoot
======================
> Both Spring and SpringBoot supports profiles
> In all approaches of Spring app development we can use profiles
a. xml driven
b. annotation driven
c. 100% code configuration
d. springboot

>Environment means the setup which is required for executing the app/project
 it contains compiled code + server + dbs/w + jar files + properties/yml etc....
> From the development to production of the project we come across multiple
 environment where code needs to be executed for different purpose.
 This environment is called "Profile".
    a. Dev environment/Dev profile
    b. test environment/Test profile
    c. uat (user acceptance test) environment/uat profile
    d. production environment/prod profile
    etc....

In our SpringApp/project
    a. To make a Sterotype annotation based spring class participating only on
       certain profiles activation we use "@Profile" on top of Spring bean class
       like @Profile("dev") or @Profile({"dev","test"})

       note: if no @Profile is specified the spring bean is available for all the profiles.

    @Repository("mySQLEmployeeDAO")
    @Profile({"dev","test"})
    public class MySqlEmployeeDaoImpl implements IEmployeeDAO{
    }
    @Repository("oracleEmployeeDAO")
    @Profile({"uat","prod"})
    public class OracleEmployeeDaoImpl implements IEmployeeDAO{
    }

    b. To make @Bean method of @Configuration class returned a java class object
       which represents a sprint bean working on certain profiles then @Profile annotation
       should be used on top of @Bean method
    @Configuration
    public class PersistenceConfig{
    @Bean("dsDBCP2")
    @Profile("dev")
    public DataSource createUsingDBCP2(){
    }
    @Bean("dsOraUCP")
    @Profile("dev")
    public DataSource createUsingOracleUCP(){
    }

> To keep application.properties/yml file into specific one profile, we create
seperate properties file for that profile as shown below
syntax:: application-<profile>.properties/yml
application.properties
application-dev.properties/yml
application-uat.properties/yml
application-pro.properties/yml
application-dev.properties/yml

How to activate the specific profile
a. In application.properites/yml : spring.profiles.active = dev
b. using -Dspring.profiles.active = dev(system property with value)

Note: if any give profile related properties file is not available then it will use
        application.properties file as fallbackproperties file.
> Getting employee record on the basis of Designation... use VO,BO,DTO

EMPDTO
=====
empNo
empName
job
sal
deptNo
MgrNo
controller => List<EmployeeVO>showEmpsByDesg(String[] desg)
service => List<EmployeeDTO>fetchEmpsByDesg(String[] desg)
dao => List<EmployeeBO> getEmpsByDesg(String cond)


sequence:: client<======VO======controller<=====DTO=====> service<=====BO=======DAO

 */



/* pom.xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.7.10</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>ineuron</groupId>
	<artifactId>BootProj11-RealTimeDI-AutoConfiguration-profiles</artifactId>
	<version>1.1</version>
	<name>BootProj11-RealTimeDI-AutoConfiguration-profiles</name>
	<description>Profiles in springboot</description>
	<properties>
		<java.version>1.8</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
			<exclusions>
				<exclusion>
					<groupId>com.zaxxer</groupId>
					<artifactId>HikariCP</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>com.oracle.database.jdbc</groupId>
			<artifactId>ojdbc8</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

	<!-- https://mvnrepository.com/artifact/com.oracle.database.jdbc/ucp -->
	<!--<dependency>
    	<groupId>com.oracle.database.jdbc</groupId>
    	<artifactId>ucp</artifactId>
	</dependency>
	-->

	<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-dbcp2 -->
	<!--<dependency>
    	<groupId>org.apache.commons</groupId>
    	<artifactId>commons-dbcp2</artifactId>
	</dependency>
-->
	<!-- https://mvnrepository.com/artifact/com.mchange/c3p0 -->
	<dependency>
    	<groupId>com.mchange</groupId>
    	<artifactId>c3p0</artifactId>
    	<version>0.9.5.5</version>
	</dependency>


	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>



 */