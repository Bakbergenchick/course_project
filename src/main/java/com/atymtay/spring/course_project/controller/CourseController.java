package com.atymtay.spring.course_project.controller;

import com.atymtay.spring.course_project.entities.LiveCourse;
import com.atymtay.spring.course_project.entities.PermanentCourse;
import com.atymtay.spring.course_project.entities.Topic;
import com.atymtay.spring.course_project.service.impls.hibernateServiceImpls.HIbLiveGenerallServiceImpl;
import com.atymtay.spring.course_project.service.impls.hibernateServiceImpls.HibPermanentGenerallServiceImpl;
import com.atymtay.spring.course_project.service.impls.jdbcServiceImpls.JDBCPermanentCourseServiceImpl;
import com.atymtay.spring.course_project.service.impls.jdbcServiceImpls.JDBCLiveCourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

//    @Autowired
//    private final LiveCourseServiceImpl liveCourseService;
//
//    private final PermanentCourseServiceImpl permanentCourseService;

//    private final JDBCLiveCourseServiceImpl jdbcLiveCourseService;
//
//    private final JDBCPermanentCourseServiceImpl jdbcPermanentCourseService;

    private final HIbLiveGenerallServiceImpl hIbLiveCourseService;

    private final HibPermanentGenerallServiceImpl hibPermanentCourseService;

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
    public List<LiveCourse> getAllLiveCourses(){
//        return jdbcLiveCourseService.getAllCourses();

        return hIbLiveCourseService.getAll();
    }

    @GetMapping("/permanent")
    public List<PermanentCourse> getAllPermanentCourses(){
//        return jdbcPermanentCourseService.getAllCourses();

        return hibPermanentCourseService.getAll();
    }

    @GetMapping("/live/{id}")
    public Optional<LiveCourse> getLiveCourseById(
            @PathVariable Long id
    ){
//        return jdbcLiveCourseService.getCourse(id);

        return hIbLiveCourseService.getById(id);
    }

    @GetMapping("/permanent/{id}")
    public Optional<PermanentCourse> getPermanentCourseById(
            @PathVariable Long id
    ){
//        return jdbcPermanentCourseService.getCourse(id);

        return hibPermanentCourseService.getById(id);
    }


    @PostMapping("/live")
    public String addLiveCourse(
              @RequestBody LiveCourse course
    ){
//        jdbcLiveCourseService.save((LiveCourse)course);
        hIbLiveCourseService.save(course);
        return "Saved!";
    }

    @PostMapping("/permanent")
    public String addPermanentCourse(
             @RequestBody PermanentCourse course
    ){
//        jdbcPermanentCourseService.save(course);
        hibPermanentCourseService.save(course);

        return "Saved!";
    }

    @PostMapping("/permanent/topic/{id}")
    public String addTopicToPermanentCourse(
            @RequestBody Topic topic,
            @PathVariable Long id
    ){
//        hIbLiveCourseService.addTopicToPermanentCourse(topic, id);
        hibPermanentCourseService.addTopicToPermanentCourse(topic, id);

        return "Topic was added!";
    }


    @DeleteMapping("/permanent/topic/{id}")
    public String removeTopicFromPermanentCourse(
            @PathVariable Long id
    ){
//        hIbLiveCourseService.removeTopicFromPermanentCourse(id);
        hibPermanentCourseService.removeTopicFromPermanentCourse(id);

        return "Topic was deleted!";
    }

//    @PutMapping("/live/{name}")
//    public String updateNameOfLiveCourse(
//            @RequestBody LiveCourse course,
//            @PathVariable String name
//    ){
//         course.setName(name);
//         jdbcLiveCourseService.update(course);
//
//        return "Updated!";
//    }

//    @PutMapping("/permanent/{name}")
//    public String updateNameOfPermanentCourse(
//            @RequestBody PermanentCourse course,
//            @PathVariable String name
//    ){
//        course.setName(name);
//        jdbcPermanentCourseService.update(course);
//
//        return "Updated!";
//    }


    @DeleteMapping("/live/{id}")
    public String deleteLiveCourse(
            @PathVariable Long id
    ){
//        jdbcLiveCourseService.deleteCourse(id);
        hIbLiveCourseService.deleteById(id);
        return "Deleted!";
    }

    @DeleteMapping("/permanent/{id}")
    public String deletePermanentCourse(
            @PathVariable Long id
    ){
//        jdbcPermanentCourseService.deleteCourse(id);
        hibPermanentCourseService.deleteById(id);

        return "Deleted!";
    }


}
