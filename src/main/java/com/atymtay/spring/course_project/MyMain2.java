package com.atymtay.spring.course_project;

import com.atymtay.spring.course_project.config.MyConfig2;
import com.atymtay.spring.course_project.service.impls.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyMain2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig2.class);

        UserServiceImpl userService = context.getBean("userService", UserServiceImpl.class);

        System.out.println(userService.getAllUsers());
    }
}
