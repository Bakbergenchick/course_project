package com.atymtay.spring.course_project.activemq;

import com.atymtay.spring.course_project.entities.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//@Slf4j
//@Component
//public class ActiveMQConsumer {
//
//    @JmsListener(destination = "queue")
//    public void processMessage(String message){
//        log.info("Received: " + message);
//    }
//
//    @JmsListener(destination = "userQueue")
//    public void userMessage(Users user){
//        log.info("User received: " + user);
//    }
//}
