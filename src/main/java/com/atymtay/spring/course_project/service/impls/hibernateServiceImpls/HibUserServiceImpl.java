package com.atymtay.spring.course_project.service.impls.hibernateServiceImpls;

import com.atymtay.spring.course_project.entities.PermanentCourse;
import com.atymtay.spring.course_project.entities.Users;
import com.atymtay.spring.course_project.repository.impls.hibernateRepoImpls.HibUserRepositoryImpl;
import com.atymtay.spring.course_project.service.GenerallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HibUserServiceImpl implements GenerallService {

    private HibUserRepositoryImpl hibUserRepository;

    @Autowired
    public HibUserServiceImpl(HibUserRepositoryImpl hibUserRepository) {
        this.hibUserRepository = hibUserRepository;
    }

    @Override
    public List<Users> getAll() {
        return hibUserRepository.getAll();
    }

    @Override
    public void save(Object object) {
        hibUserRepository.save(object);
    }

    @Override
    public void update(Object object) {
        hibUserRepository.update(object);
    }

    @Override
    public Optional<Users> getById(Long id) {
        return hibUserRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        hibUserRepository.deleteById(id);
    }

    public void addPermanentCourseToUser(Long user_id, Long permanentCourse_id){
        hibUserRepository.addPermanentCourseToUser(user_id, permanentCourse_id);
    }
}
