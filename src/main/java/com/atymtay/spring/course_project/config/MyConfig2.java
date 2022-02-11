package com.atymtay.spring.course_project.config;

import com.atymtay.spring.course_project.repository.DBManagerUsers;
import com.atymtay.spring.course_project.service.impls.UserServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class MyConfig2 {

    @Bean(name = "userService")
    @DependsOn(value = "userDb")
    public UserServiceImpl userService(){
        return new UserServiceImpl(dbManagerUsers());
    }

    @Bean(name = "userDb")
    public DBManagerUsers dbManagerUsers(){
        return new DBManagerUsers();
    }



}
