package org.example;

import org.example.adddata.AddedDataFromJsonToBd;
import org.example.config.SpringConfig;
import org.example.service.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

//        Service service = context.getBean("serviceImpl", Service.class);
//        if (args.length > 0) {
//            service = new ServiceImpl(args[0]);
//        } else {
//            service = new ServiceImpl("");
//        }

//        service.createUniqueParams();
//        service.createParamsWellsInRange(10, 12);
//        service.createDepartmentsAndWells();
    }
}
