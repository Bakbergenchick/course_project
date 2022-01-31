package com.atymtay.spring.course_project;

import com.atymtay.spring.course_project.service.impls.LiveCourseServiceImpl;
import com.atymtay.spring.course_project.service.impls.PermanentCourseServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CourseProjectApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CourseProjectApplication.class, args);

        LiveCourseServiceImpl liveCourseService = context.getBean(LiveCourseServiceImpl.class);
        PermanentCourseServiceImpl permanentCourseService = context.getBean(PermanentCourseServiceImpl.class);

        System.out.printf("This '%s' implementation\n",liveCourseService.getMessage());
        System.out.printf("This '%s' implementation",permanentCourseService.getMessage());

    }

}
