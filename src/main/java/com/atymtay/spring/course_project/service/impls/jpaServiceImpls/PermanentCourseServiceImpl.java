package com.atymtay.spring.course_project.service.impls.jpaServiceImpls;

import com.atymtay.spring.course_project.entities.PermanentCourse;


import com.atymtay.spring.course_project.service.GenerallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//@Service
//public class PermanentCourseServiceImpl implements GenerallService {
//
//    private final PermanentRepository permanentRepository;
//
//    @Autowired
//    public PermanentCourseServiceImpl(PermanentRepository permanentCourse){
//        this.permanentRepository = permanentCourse;
//    }
//
//    @Override
//    public List<PermanentCourse> getAll() {
//        return permanentRepository.findAll();
//    }
//
//    @Override
//    public void save(Object object) {
//        permanentRepository.save((PermanentCourse) object);
//    }
//
//    @Override
//    public void update(Object object) {
//        permanentRepository.save((PermanentCourse) object);
//    }
//
//    @Override
//    public Optional<PermanentCourse> getById(Long id) {
//        return Optional.of(permanentRepository.getById(id));
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        permanentRepository.deleteById(id);
//    }
//}
