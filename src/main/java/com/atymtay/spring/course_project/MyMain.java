package com.atymtay.spring.course_project;

import com.atymtay.spring.course_project.config.MyConfig;
import com.atymtay.spring.course_project.entities.Users;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

//public class MyMain {
//    public static void main(String[] args) {
//        GenericApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
//
//        Users user1_1 = context.getBean("user1",Users.class);
//        Users user1_2 = context.getBean("user1",Users.class);
//
//
////        Users user2 = context.getBean("user2",Users.class);
//
//
//        System.out.println(user1_1.equals(user1_2));
////        System.out.println(user2);
//
//        context.getBeanDefinitionNames();
//        context.close();
//    }
//}
