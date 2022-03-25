package com.atymtay.spring.course_project.service.impls.jpaServiceImpls;

import com.atymtay.spring.course_project.entities.LiveCourse;


import com.atymtay.spring.course_project.repository.impls.jpaRepoImpls.LiveCourseRepository;
import com.atymtay.spring.course_project.service.GenerallService;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LiveCourseServiceImpl implements GenerallService {

    private final LiveCourseRepository liveCourseRepository;


    @Autowired
    public LiveCourseServiceImpl(LiveCourseRepository liveCourseRepository) {
        this.liveCourseRepository = liveCourseRepository;
    }


    @Override
    public List<LiveCourse> getAll() {
        return liveCourseRepository.findAll();
    }

    @Override
    public void save(Object object) {
        liveCourseRepository.save((LiveCourse) object);
    }

    @Override
    public void update(Object object) {
        liveCourseRepository.save((LiveCourse) object);
    }

    @Override
    public Optional<LiveCourse> getById(Long id) {
        return Optional.of(liveCourseRepository.getById(id));
    }

    @Override
    public void deleteById(Long id) {
        liveCourseRepository.deleteById(id);
    }
}
