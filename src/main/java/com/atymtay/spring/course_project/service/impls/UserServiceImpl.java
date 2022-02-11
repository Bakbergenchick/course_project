package com.atymtay.spring.course_project.service.impls;

import com.atymtay.spring.course_project.entities.Users;
import com.atymtay.spring.course_project.repository.DBManagerUsers;
import com.atymtay.spring.course_project.repository.UsersRepository;
import com.atymtay.spring.course_project.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public class UserServiceImpl implements UsersService {

//    private final UsersRepository usersRepository;

    private DBManagerUsers dbManagerUsers;


    @Autowired
    public UserServiceImpl(@Qualifier("userDb") DBManagerUsers dbManagerUsers){
        this.dbManagerUsers = dbManagerUsers;
    }

    public UserServiceImpl() {

    }

    @Override
    public List<Users> getAllUsers() {
        return dbManagerUsers.getUserlist();
    }

    @Override
    public void saveUser(Users user) {
        dbManagerUsers.addUser(user);
    }

    @Override
    public Optional<Users> getUser(Long id) {
        return Optional.ofNullable(dbManagerUsers.getUser(id));
    }

    @Override
    public void deleteUser(Long id) {
        dbManagerUsers.deleteUser(id);
    }




}
