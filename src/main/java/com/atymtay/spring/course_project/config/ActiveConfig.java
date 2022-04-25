package com.atymtay.spring.course_project.config;

import com.atymtay.spring.course_project.entities.Users;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.Collections;

//@Configuration
//public class ActiveConfig {
//
//    @Bean
//    public MessageConverter jacksonJmsMessageConverter() {
//        val converter = new MappingJackson2MessageConverter();
//        converter.setTypeIdMappings(Collections.singletonMap("user", Users.class));
//        converter.setTypeIdPropertyName("content-type");
//        return converter;
//    }
//}
