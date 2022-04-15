package com.atymtay.spring.course_project.service.impls.jpaServiceImpls;

import com.atymtay.spring.course_project.entities.LiveCourse;


import com.atymtay.spring.course_project.repository.impls.jpaRepoImpls.LiveCourseRepository;
import com.atymtay.spring.course_project.service.GenerallService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@PropertySource("classpath:application.properties")
public class LiveCourseServiceImpl implements GenerallService {

    private final LiveCourseRepository liveCourseRepository;


    @Autowired
    public LiveCourseServiceImpl(LiveCourseRepository liveCourseRepository) {
        this.liveCourseRepository = liveCourseRepository;
    }


    @Override
//    @Transactional(readOnly = true, timeout = 3)
    public List<LiveCourse> getAll() throws Exception{
//        Thread.sleep(5000);
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
    @Transactional(readOnly = true)
    public Optional<LiveCourse> getById(Long id) {
        return Optional.of(liveCourseRepository.getById(id));
    }

    @Override
    public void deleteById(Long id) {
        liveCourseRepository.deleteById(id);
    }

//    @Scheduled(cron = "${task.delayTime}")
////    @Scheduled(fixedDelayString = "${task.delayTime}")
//    @Scheduled(fixedDelay = 4000L, initialDelay = 1000L)
//    public void updateRatingByPrice(){
//        log.info("Starting the process update...");
//
//        List<LiveCourse> liveCourseList = liveCourseRepository.findAll();
//
//        liveCourseList.stream()
//                .filter(l -> l.getPrice() > 20)
//                .forEach(l -> {
//
//                    l.setRating(0);
//
//                    update(l);
//                });
//
//        log.info("Current time is " + new Date());
//        log.info("Course updated successfully!");
//    }
}
