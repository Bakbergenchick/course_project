package com.atymtay.spring.course_project.config;

import com.atymtay.spring.course_project.entities.Users;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.atymtay.spring.course_project.entities")
//@PropertySource("classpath:myConfig.properties")
public class MyConfig {

    @Bean(initMethod = "initUser", destroyMethod = "destroyUser")
    @Lazy
    @Scope("singleton")
    public Users user1(){
        Users user = new Users();

       user.setName("Bakbergen");
       user.setSurname("Atymtay");
       user.setEmail("sefsef@");

       return user;
    }


    @Bean(initMethod = "initUser", destroyMethod = "destroyUser")
    @Lazy
    @Scope("prototype")
    public Users user2(){
        Users user = new Users();

        user.setId(3L);
        user.setSurname("Shakirov");
        user.setEmail("awd@sef.com");
        user.setPassword("1232345345");

        return user;
    }


}