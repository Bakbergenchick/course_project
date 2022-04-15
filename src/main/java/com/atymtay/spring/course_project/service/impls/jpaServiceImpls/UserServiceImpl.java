package com.atymtay.spring.course_project.service.impls.jpaServiceImpls;

import com.atymtay.spring.course_project.entities.PermanentCourse;
import com.atymtay.spring.course_project.entities.Users;


import com.atymtay.spring.course_project.exception.CustomErrorException;
import com.atymtay.spring.course_project.repository.impls.jpaRepoImpls.PermanentRepository;
import com.atymtay.spring.course_project.repository.impls.jpaRepoImpls.UsersRepository;
import com.atymtay.spring.course_project.service.GenerallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    @Transactional(readOnly = true)
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    public Page<Users> getPaged(int page, int size){
        return usersRepository.findAll(PageRequest.of(page, size));
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
        Optional<Users> user = usersRepository.findById(id);

        if(user.isPresent())
            return user;

        throw new CustomErrorException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "User with id=" + id + " not found",
                (Long) id
        );
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
