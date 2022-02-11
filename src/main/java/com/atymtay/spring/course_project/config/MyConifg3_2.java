package com.atymtay.spring.course_project.config;

import com.atymtay.spring.course_project.repository.DBManagerUsers;
import com.atymtay.spring.course_project.service.UsersService;
import com.atymtay.spring.course_project.service.impls.teacher.UserServiceImpl2;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@Profile("teacher")
public class MyConifg3_2 {

    @Bean("userServImpl")
    public UserServiceImpl2 userServiceImpl(){
        return new UserServiceImpl2();
    }

    @Bean("userServ")
    public UsersService usersService(){
        return new UserServiceImpl2();
    }




}
