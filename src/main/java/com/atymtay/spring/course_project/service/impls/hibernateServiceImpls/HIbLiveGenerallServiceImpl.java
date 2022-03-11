package com.atymtay.spring.course_project.service.impls.hibernateServiceImpls;

import com.atymtay.spring.course_project.entities.LiveCourse;
import com.atymtay.spring.course_project.repository.impls.hibernateRepoImpls.HibLiveGenerallRepositoryImpl;
import com.atymtay.spring.course_project.service.GenerallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HIbLiveGenerallServiceImpl implements GenerallService {

    private HibLiveGenerallRepositoryImpl hibLiveCourseRepository;

    @Autowired
    public HIbLiveGenerallServiceImpl(HibLiveGenerallRepositoryImpl hibLiveCourseRepository) {
        this.hibLiveCourseRepository = hibLiveCourseRepository;
    }

    @Override
    public List<LiveCourse> getAll() {
        return hibLiveCourseRepository.getAll();
    }

    @Override
    public void save(Object object) {
        hibLiveCourseRepository.save(object);
    }

    @Override
    public void update(Object object) {
        hibLiveCourseRepository.update(object);
    }

    @Override
    public Optional<LiveCourse> getById(Long id) {
        return hibLiveCourseRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        hibLiveCourseRepository.deleteById(id);
    }


}
