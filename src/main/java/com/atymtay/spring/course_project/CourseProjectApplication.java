package com.atymtay.spring.course_project;


import com.atymtay.spring.course_project.config.KafkaMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@EnableAspectJAutoProxy
//@EnableCaching
@EnableScheduling
@EnableJms
@EnableKafka
public class CourseProjectApplication {

    public static void main(String[] args) {
       SpringApplication.run(CourseProjectApplication.class, args);
    }

}
