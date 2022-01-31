package com.atymtay.spring.course_project.controller;

import com.atymtay.spring.course_project.entities.LiveCourse;
import com.atymtay.spring.course_project.entities.PermanentCourse;
import com.atymtay.spring.course_project.service.CourseService;
import com.atymtay.spring.course_project.service.impls.LiveCourseServiceImpl;
import com.atymtay.spring.course_project.service.impls.PermanentCourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MyController {

//    @Autowired
    private final LiveCourseServiceImpl liveCourseService;

    private final PermanentCourseServiceImpl permanentCourseService;

//    @Autowired
//    public MyController(CourseService courseService) {
//        this.courseService = courseService;
//    }

    @GetMapping("/courses/live")
    public List<LiveCourse> getAllLiveCourses(){
        return liveCourseService.getAllCourses();
    }

    @GetMapping("/courses/permanent")
    public List<PermanentCourse> getAllPermanentCourses(){
        return permanentCourseService.getAllCourses();
    }

    @GetMapping("/courses/live/{id}")
    public Optional<LiveCourse> getLiveCourseById(
            @PathVariable Long id
    ){
        return liveCourseService.getCourse(id);
    }

    @GetMapping("/courses/permanent/{id}")
    public Optional<PermanentCourse> getPermanentCourseById(
            @PathVariable Long id
    ){
        return permanentCourseService.getCourse(id);
    }


    @PostMapping("/courses/live")
    public String addLiveCourse(
              @RequestBody LiveCourse course
    ){
        liveCourseService.saveCourse(course);

        return "Saved!";
    }


    @PostMapping("/courses/permanent")
    public String addPermanentCourse(
             @RequestBody PermanentCourse course
    ){
        permanentCourseService.saveCourse(course);

        return "Saved!";
    }
}
