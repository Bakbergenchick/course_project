package com.atymtay.spring.course_project.controller;

import com.atymtay.spring.course_project.entities.LiveCourse;
import com.atymtay.spring.course_project.repository.LiveCourseRepository;
import com.atymtay.spring.course_project.service.impls.LiveCourseServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MyController.class)
class MyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LiveCourseRepository liveCourseRepository;

    @Test
    void getAllLiveCourses() throws Exception {
        when(liveCourseRepository.findAll())
                .thenReturn(Arrays.asList(
                    new LiveCourse(1L, "C++", 233, 4.3, "2021/02/21","2021/04/21"),
                    new LiveCourse(2L, "Java", 433, 4.6, "2021/06/11","2021/05/11")
                ));

        mockMvc.perform(get("/api/courses/live"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[*].id",containsInAnyOrder(1,2)))
                .andExpect(jsonPath("$[*].name",containsInAnyOrder("C++","Java")));
    }

    @Test
    void getLiveCourseById() throws Exception {
        when(liveCourseRepository.findById(anyLong()))
                .thenReturn(
                        Optional.of(new LiveCourse(1L, "C++", 233, 4.3,
                                "2021/02/21", "2021/04/21"))
                );

        mockMvc.perform(get("/api/courses/live/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",equalTo(1)))
                .andExpect(jsonPath("$.name",equalTo("C++")));
    }
}