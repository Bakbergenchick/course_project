package com.atymtay.spring.course_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableCaching
public class CourseProjectApplication {

    public static void main(String[] args) {
       SpringApplication.run(CourseProjectApplication.class, args);

//        UserServiceImpl userService = context.getBean( UserServiceImpl.class);
//        LiveCourseServiceImpl2 liveCourseServiceImpl2 = context.getBean(LiveCourseServiceImpl2.class);
//
//        liveCourseServiceImpl2.addByRole("Bakbergen", new LiveCourse("GO", 345,
//                3.5, "#45", "#345" ));
//
//        System.out.println(liveCourseServiceImpl2.getAllCourses());


//        try{
//            Optional<Users> users = userService.getUser(2L);
//            System.out.println(users);
//        } catch (Exception e){
//            System.out.println("Exception type = ' " + e+ " '");
//        }



//        System.out.println(userService.getAllUsers());


//        context.close();
    }

}
