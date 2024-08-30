package com.app;

import com.app.target.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Sb008DiJavaConfigApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Sb008DiJavaConfigApplication.class, args);
        System.out.println("Beans info are :: " + Arrays.toString(context.getBeanDefinitionNames()));
        System.out.println();
        Student student = context.getBean(Student.class);
        System.out.println(student);
        student.preparation(student.getMaterial().getClass().getName());
        ((ConfigurableApplicationContext) context).close();
    }

}

/*

@Component, @Autowired are the annotations given spring
Alternately we can use @Named, @Resource, @Inject which are supplied by JSE,JEE modules(from
java9 they are released as independent libraries)

> For these annotations, they underlying framework or container or server decides the
  functionality
    In Spring, the spring framework will decide the functionality for annotations given by java.
    In hibernate, the hibernate framework will decide the functionality for annotations given by java.
    In Servlet, the servlet container will decide the functionality for annotations given by java.
    eg: @PostConstruct,@PreDestroy,@Named,@Resource,@Inject,.....

    @Named:: To configure java class as SpringBean and also to resolve ambiguity.
    @Inject,@Resource :: They are alternative to @Autowired for Dependency Injection.
    Unlike @Autowired, @Resource can't be applied at constructor level injection.

SpringBean class with Spring supplied annotations like @Component,@Autowired,@Qualifier
make spring bean class as "Invasive".

To make SpringBean class as non-invasive take the support of Java Config Annotation.
Note:As of now very limited java config are available,so it is practically impossible to
develop entire spring or spring boot application using java config annotation.
    so we prefer the following order
    a. if available, always try to use Java config annotation
    b. else use Spring annotations
    c. third party annotations
    d. custom annotations

To use java config annotations we need to add the following jar file
    pom.xml
    =======
    <dependency>
        <groupId>javax.inject</groupId>
        <artifactId>javax.inject</artifactId>
        <version>1</version>
    </dependency>
> @Inject can be used at field level,constructor level,setter method level
> @Resource can be used at field level,setter method level.
> While working with @Inject we need to use @Named to resolve the ambiguity problem.
> While working with @Resource only "name" param itself would resolve the problem.
 */