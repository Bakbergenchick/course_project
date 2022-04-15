package com.atymtay.spring.course_project.controller;

import com.atymtay.spring.course_project.entities.LiveCourse;
import com.atymtay.spring.course_project.entities.PermanentCourse;
import com.atymtay.spring.course_project.entities.Topic;
import com.atymtay.spring.course_project.service.impls.jpaServiceImpls.LiveCourseServiceImpl;
import com.atymtay.spring.course_project.service.impls.jpaServiceImpls.PermanentCourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

      private final LiveCourseServiceImpl liveCourseService;
      private final PermanentCourseServiceImpl permanentCourseService;
//    @Autowired
//    public MyController(CourseService courseService) {
//        this.courseService = courseService;
//    }

//    @PostConstruct
//    private void postConstruct() {
//        System.out.println("\nAdded default course!");
//        LiveCourse liveCourse = new LiveCourse(null, "Java", 234, 4.5, "12/12/2021", "12/12/2022");
//        liveCourseService.saveCourse(liveCourse);
//    }
//
//    @PreDestroy
//    private void preDestroy() {
//        System.out.println("\nClean up db from LiveCourses!");
//
//        List<LiveCourse> liveCourseList = liveCourseService.getAllCourses();
//
//        liveCourseList.forEach(course -> liveCourseService.deleteCourse(course.getId()));
//
//
//    }

    @GetMapping("/live")
    public List<LiveCourse> getAllLiveCourses() throws Exception{

        return liveCourseService.getAll();
    }

    @GetMapping("/permanent")
    public List<PermanentCourse> getAllPermanentCourses(){

        return permanentCourseService.getAll();
    }

    @GetMapping("/live/{id}")
    public Optional<LiveCourse> getLiveCourseById(
            @PathVariable Long id
    ){

        return liveCourseService.getById(id);
    }

    @GetMapping("/permanent/{id}")
    public Optional<PermanentCourse> getPermanentCourseById(
            @PathVariable Long id
    ){
//        return jdbcPermanentCourseService.getCourse(id);

        return permanentCourseService.getById(id);
    }


    @PostMapping("/live")
    public String addLiveCourse(
              @RequestBody LiveCourse course
    ){
        liveCourseService.save(course);

        return "Saved!";
    }

    @PostMapping("/permanent")
    public String addPermanentCourse(
             @RequestBody PermanentCourse course
    ){
        permanentCourseService.save(course);

        return "Saved!";
    }

    @PostMapping("/permanent/topic/{id}")
    public String addTopicToPermanentCourse(
            @RequestBody Topic topic,
            @PathVariable Long id
    ){
        permanentCourseService.addTopicToPermanentCourse(topic, id);

        return "Topic was added!";
    }


    @DeleteMapping("/permanent/topic/{id}")
    public String removeTopicFromPermanentCourse(
            @PathVariable Long id
    ){
        permanentCourseService.removeTopicFromPermanentCourse(id);

        return "Topic was deleted!";
    }


    @DeleteMapping("/live/{id}")
    public String deleteLiveCourse(
            @PathVariable Long id
    ){
        liveCourseService.deleteById(id);

        return "Deleted!";
    }

    @DeleteMapping("/permanent/{id}")
    public String deletePermanentCourse(
            @PathVariable Long id
    ){

        permanentCourseService.deleteById(id);

        return "Deleted!";
    }


}
