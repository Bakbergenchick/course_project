package com.atymtay.spring.course_project.service.impls.hibernateServiceImpls;

import com.atymtay.spring.course_project.entities.PermanentCourse;
import com.atymtay.spring.course_project.entities.Topic;
import com.atymtay.spring.course_project.repository.impls.hibernateRepoImpls.HibPermanentGenerallRepositoryImpl;
import com.atymtay.spring.course_project.service.GenerallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HibPermanentGenerallServiceImpl implements GenerallService {

    private HibPermanentGenerallRepositoryImpl hibPermanentCourseRepository;


    @Autowired
    public HibPermanentGenerallServiceImpl(HibPermanentGenerallRepositoryImpl hibPermanentCourseRepository) {
        this.hibPermanentCourseRepository = hibPermanentCourseRepository;
    }

    @Override
    public List<PermanentCourse> getAll() {
        return hibPermanentCourseRepository.getAll();
    }

    @Override
    public void save(Object object) {
        hibPermanentCourseRepository.save(object);
    }

    @Override
    public void update(Object object) {
        hibPermanentCourseRepository.update(object);
    }

    @Override
    public Optional<PermanentCourse> getById(Long id) {
        return hibPermanentCourseRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        hibPermanentCourseRepository.deleteById(id);
    }

    public void addTopicToPermanentCourse(Topic topic, Long id){
        hibPermanentCourseRepository.addTopicToPermanentCourse(topic, id);
    }

    public void removeTopicFromPermanentCourse(Long id) {
        hibPermanentCourseRepository.removeTopicFromPermanentCourse(id);
    }
}
