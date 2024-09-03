package com.app;

import com.app.components.BillGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;


//usage of Spring Expression Language
@SpringBootApplication
public class Sb012SpExpressionLanguageApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Sb012SpExpressionLanguageApplication.class, args);
        System.out.println("Beans info are :: " + Arrays.toString(context.getBeanDefinitionNames()));
        System.out.println();

        BillGenerator billGenerator = context.getBean(BillGenerator.class);
        System.out.println(billGenerator);

        ((ConfigurableApplicationContext) context).close();
    }

}
