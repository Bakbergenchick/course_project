package com.atymtay.spring.course_project.controller;

import com.atymtay.spring.course_project.entities.LiveCourse;
import com.atymtay.spring.course_project.entities.PermanentCourse;
import com.atymtay.spring.course_project.entities.Users;
import com.atymtay.spring.course_project.service.CourseService;
import com.atymtay.spring.course_project.service.impls.LiveCourseServiceImpl;
import com.atymtay.spring.course_project.service.impls.PermanentCourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

//    @Autowired
    private final LiveCourseServiceImpl liveCourseService;

    private final PermanentCourseServiceImpl permanentCourseService;

//    @Autowired
//    public MyController(CourseService courseService) {
//        this.courseService = courseService;
//    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("\nAdded default course!");
        LiveCourse liveCourse = new LiveCourse(null, "Java", 234, 4.5, "12/12/2021", "12/12/2022");
        liveCourseService.saveCourse(liveCourse);
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("\nClean up db from LiveCourses!");

        List<LiveCourse> liveCourseList = liveCourseService.getAllCourses();

        liveCourseList.forEach(course -> liveCourseService.deleteCourse(course.getId()));


    }

    @GetMapping("/live")
    public List<LiveCourse> getAllLiveCourses(){
        return liveCourseService.getAllCourses();
    }

    @GetMapping("/permanent")
    public List<PermanentCourse> getAllPermanentCourses(){
        return permanentCourseService.getAllCourses();
    }

    @GetMapping("/live/{id}")
    public Optional<LiveCourse> getLiveCourseById(
            @PathVariable Long id
    ){
        return liveCourseService.getCourse(id);
    }

    @GetMapping("/permanent/{id}")
    public Optional<PermanentCourse> getPermanentCourseById(
            @PathVariable Long id
    ){
        return permanentCourseService.getCourse(id);
    }


    @PostMapping("/live")
    public String addLiveCourse(
              @RequestBody LiveCourse course
    ){
        liveCourseService.saveCourse(course);

        return "Saved!";
    }


    @PostMapping("/permanent")
    public String addPermanentCourse(
             @RequestBody PermanentCourse course
    ){
        permanentCourseService.saveCourse(course);

        return "Saved!";
    }
}
