package com.vignesh;

import com.vignesh.target.Package;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath:configuration/applicationContext.xml")
public class Sb002DependencyInjectionApplication {

    public static void main(String[] args) {
        ApplicationContext iocContainer = SpringApplication.run(Sb002DependencyInjectionApplication.class, args);
        Package packageBean = iocContainer.getBean("package",Package.class);
        System.out.println(packageBean.packageInfo());
    }

}
