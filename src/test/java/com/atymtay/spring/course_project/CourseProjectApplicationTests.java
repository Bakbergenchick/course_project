package com.atymtay.spring.course_project;

import com.atymtay.spring.course_project.config.MyConfig;
import com.atymtay.spring.course_project.entities.Users;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootTest
class CourseProjectApplicationTests {

    @Test
    void contextLoads() {
        GenericApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Users user = context.getBean("user1", Users.class);
        Assert.assertNull(user);

        context.close();
    }

}
