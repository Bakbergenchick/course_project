package com.atymtay.spring.course_project.activemq;

import com.atymtay.spring.course_project.entities.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/api/active")
//@RequiredArgsConstructor
//public class ActiveMQController {
//
//    private final JmsTemplate jmsTemplate;
//
//    @PostMapping(value = "/send/{message}", produces = "text/plain")
//    public ResponseEntity<String> sendMessage(@PathVariable String message){
//        jmsTemplate.convertAndSend("queue", message);
//
//        return new ResponseEntity<>("Done!", HttpStatus.ACCEPTED);
//    }
//
//    @PostMapping(value = "/send/user", produces = "text/plain")
//    public ResponseEntity<String> sendMessageToUser(@RequestBody Users user){
//        jmsTemplate.convertAndSend("userQueue", user);
//
//        return new ResponseEntity<>("User sended!", HttpStatus.ACCEPTED);
//    }
//
//
//}
