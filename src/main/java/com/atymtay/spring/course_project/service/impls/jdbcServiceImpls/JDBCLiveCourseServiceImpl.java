package com.atymtay.spring.course_project.service.impls.jdbcServiceImpls;

import com.atymtay.spring.course_project.entities.LiveCourse;
import com.atymtay.spring.course_project.repository.impls.jdbcRepoImpls.JDBCGenerallRepositoryImpl;
import com.atymtay.spring.course_project.service.JDBCCourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JDBCLiveCourseServiceImpl implements JDBCCourseService {

    private final JDBCGenerallRepositoryImpl jdbcLiveCourseRepository;

    public JDBCLiveCourseServiceImpl(JDBCGenerallRepositoryImpl jdbcLiveCourseRepository) {
        this.jdbcLiveCourseRepository = jdbcLiveCourseRepository;
    }


    @Override
    public List<LiveCourse> getAllCourses() {
        return jdbcLiveCourseRepository.getAll();
    }

    @Override
    public Optional<LiveCourse> getCourse(Long id) {
        return jdbcLiveCourseRepository.getById(id);
    }

    @Override
    public void deleteCourse(Long id) {
        jdbcLiveCourseRepository.deleteById(id);
    }

    @Override
    public Optional<LiveCourse> getCourseByName(String name) {
        return jdbcLiveCourseRepository.getByName(name);
    }

    @Override
    public void save(Object liveCourse) {
        jdbcLiveCourseRepository.save((LiveCourse)liveCourse);
    }

    @Override
    public void update(Object liveCourse) {
        jdbcLiveCourseRepository.update((LiveCourse)liveCourse);
    }
}
