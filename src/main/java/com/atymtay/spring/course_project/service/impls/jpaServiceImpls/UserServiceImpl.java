package com.atymtay.spring.course_project.service.impls.jpaServiceImpls;

import com.atymtay.spring.course_project.entities.Users;


import com.atymtay.spring.course_project.service.GenerallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
//public class UserServiceImpl implements GenerallService {
//
//    private final UsersRepository usersRepository;
//
//    @Autowired
//    public UserServiceImpl(UsersRepository usersRepository) {
//        this.usersRepository = usersRepository;
//    }
//
//    @Override
//    public List<Users> getAll() {
//        return usersRepository.findAll();
//    }
//
//    @Override
//    public void save(Object object) {
//        usersRepository.save((Users) object);
//    }
//
//    @Override
//    public void update(Object object) {
//        usersRepository.save((Users) object);
//    }
//
//    @Override
//    public Optional<Users> getById(Long id) {
//        return Optional.of(usersRepository.getById(id));
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        usersRepository.deleteById(id);
//    }
//}
