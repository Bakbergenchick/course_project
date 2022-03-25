package com.atymtay.spring.course_project.service.impls.jpaServiceImpls;

import com.atymtay.spring.course_project.entities.PermanentCourse;
import com.atymtay.spring.course_project.entities.Users;


import com.atymtay.spring.course_project.repository.impls.jpaRepoImpls.PermanentRepository;
import com.atymtay.spring.course_project.repository.impls.jpaRepoImpls.UsersRepository;
import com.atymtay.spring.course_project.service.GenerallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements GenerallService {

    private final UsersRepository usersRepository;
    private final PermanentRepository permanentRepository;


    @Autowired
    public UserServiceImpl(UsersRepository usersRepository, PermanentRepository permanentRepository) {
        this.usersRepository = usersRepository;
        this.permanentRepository = permanentRepository;
    }


    @Override
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public void save(Object object) {
        usersRepository.save((Users) object);
    }

    @Override
    public void update(Object object) {
        usersRepository.save((Users) object);
    }

    @Override
    public Optional<Users> getById(Long id) {
        return Optional.of(usersRepository.getById(id));
    }

    @Override
    public void deleteById(Long id) {
        usersRepository.deleteById(id);
    }

    public void addPermanentCourseToUser(Long user_id, Long permanentCourse_id){


        Users user = usersRepository.getById(user_id);

        PermanentCourse permanentCourse = permanentRepository.getById(permanentCourse_id);

        Set<PermanentCourse> permanentCourseSet = user.getPermanentCourses();

        permanentCourseSet.add(permanentCourse);

        usersRepository.save(user);

    }
}
