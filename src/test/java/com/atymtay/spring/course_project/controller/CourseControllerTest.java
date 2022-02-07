package com.atymtay.spring.course_project.controller;

import com.atymtay.spring.course_project.entities.LiveCourse;
import com.atymtay.spring.course_project.repository.LiveCourseRepository;
import com.atymtay.spring.course_project.service.CourseService;
import com.atymtay.spring.course_project.service.impls.LiveCourseServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DataJpaTest
@SpringBootTest
class CourseControllerTest {


    @Autowired
    private LiveCourseRepository liveCourseRepository;

    @Test
    void getAllCourse(){
        LiveCourse liveCourse = new LiveCourse(10L, "Go", 323, 5, "2021/20/10", "2022/20/31");

        liveCourseRepository.save(liveCourse);

        assertEquals(liveCourseRepository.findById(10L).orElse(null), liveCourse);
//        assertEquals();

    }
}