package com.atymtay.spring.course_project.service.impls.user;


import com.atymtay.spring.course_project.entities.Users;
import com.atymtay.spring.course_project.repository.DBManagerUsers;
import com.atymtay.spring.course_project.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl2 implements UsersService {

    @Override
    public List<Users> getAllUsers() {;
        return List.of(new Users(1L,"Bakbergen", "Atymtay", "2342@.awd.cp", "23423"),
                new Users(2L, "Ulan", "Rakhat", "345345#@.erf", "3345"));
    }

    @Override
    public void saveUser(Users user) {

    }

    @Override
    public Optional<Users> getUser(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteUser(Long id) {

    }
}
