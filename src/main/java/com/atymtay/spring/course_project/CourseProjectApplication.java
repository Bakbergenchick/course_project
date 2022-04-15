package com.atymtay.spring.course_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableAspectJAutoProxy
//@EnableCaching
//@EnableScheduling
public class CourseProjectApplication {

    public static void main(String[] args) {
       SpringApplication.run(CourseProjectApplication.class, args);

    }

}
