package com.atymtay.spring.course_project.service.impls.jdbcServiceImpls;

import com.atymtay.spring.course_project.entities.PermanentCourse;
import com.atymtay.spring.course_project.repository.impls.jdbcRepoImpls.JDBCPermanentGenerallRepositoryImpl;
import com.atymtay.spring.course_project.service.JDBCCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JDBCPermanentCourseServiceImpl implements JDBCCourseService {

    private final JDBCPermanentGenerallRepositoryImpl jdbcPermanentCourseService;

    @Autowired
    public JDBCPermanentCourseServiceImpl(JDBCPermanentGenerallRepositoryImpl jdbcPermanentCourseService) {
        this.jdbcPermanentCourseService = jdbcPermanentCourseService;
    }


    @Override
    public List<PermanentCourse> getAllCourses() {
        return jdbcPermanentCourseService.getAll();
    }

    @Override
    public Optional<PermanentCourse> getCourse(Long id) {
        return jdbcPermanentCourseService.getById(id);
    }

    @Override
    public void deleteCourse(Long id) {
        jdbcPermanentCourseService.deleteById(id);
    }

    @Override
    public Optional<PermanentCourse> getCourseByName(String name) {
        return jdbcPermanentCourseService.getByName(name);
    }

    @Override
    public void save(Object liveCourse) {
        jdbcPermanentCourseService.save(liveCourse);
    }

    @Override
    public void update(Object liveCourse) {
        jdbcPermanentCourseService.update(liveCourse);
    }
}
