package com.atymtay.spring.course_project.service.impls;

import com.atymtay.spring.course_project.entities.PermanentCourse;
import com.atymtay.spring.course_project.repository.PermanentRepository;
import com.atymtay.spring.course_project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PermanentCourseServiceImpl implements CourseService {

//    @Autowired
    private PermanentRepository permanentRepository;

    @Value("${msg.permanentCourse}")
    private String message;

    @Autowired
    public PermanentCourseServiceImpl(PermanentRepository permanentCourse){
        this.permanentRepository = permanentCourse;
    }

//    @Autowired
    public void setCourseRepository(PermanentRepository liveCourseRepository) {
        this.permanentRepository = liveCourseRepository;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public List<PermanentCourse> getAllCourses() {
        return permanentRepository.findAll();
    }

    @Override
    public void saveCourse(Object course) {
        permanentRepository.save((PermanentCourse) course);
    }

    @Override
    public Optional<PermanentCourse> getCourse(Long id) {
        return permanentRepository.findById(id);
    }

    @Override
    public void deleteCourse(Long id) {
        permanentRepository.deleteById(id);
    }
}
