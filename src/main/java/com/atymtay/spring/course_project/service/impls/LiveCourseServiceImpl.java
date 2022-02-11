package com.atymtay.spring.course_project.service.impls;

import com.atymtay.spring.course_project.entities.LiveCourse;
import com.atymtay.spring.course_project.repository.LiveCourseRepository;
import com.atymtay.spring.course_project.service.CourseService;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LiveCourseServiceImpl implements CourseService {

    private final LiveCourseRepository liveCourseRepository;

    @Value("${msg.liveCourse}")
    private String message;

    @Autowired
    public LiveCourseServiceImpl(LiveCourseRepository liveCourseRepository) {
        this.liveCourseRepository = liveCourseRepository;
    }


    public String getMessage() {
        return message;
    }

    @Override
    public List<LiveCourse> getAllCourses() {

        return liveCourseRepository.findAll();
    }

    @Override
    public void saveCourse(Object course) {
        liveCourseRepository.save((LiveCourse) course);
    }

    @Override
    public Optional<LiveCourse> getCourse(Long id) {
        return liveCourseRepository.findById(id);
    }

    @Override
    public void deleteCourse(Long id) {
        liveCourseRepository.deleteById(id);
    }
}
