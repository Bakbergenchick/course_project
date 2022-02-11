package com.atymtay.spring.course_project;

import com.atymtay.spring.course_project.config.MyConfig3_1;
import com.atymtay.spring.course_project.config.MyConifg3_2;
import com.atymtay.spring.course_project.service.UsersService;
import com.atymtay.spring.course_project.service.impls.teacher.UserServiceImpl2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication(scanBasePackages = "com.atymtay.spring.course_project.service.impls")
public class MyMain3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig3_1.class, MyConifg3_2.class);

        UsersService usersService = context.getBean("userServ", UsersService.class);

        System.out.println(usersService.getAllUsers());
    }
}
