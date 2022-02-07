package com.atymtay.spring.course_project.service;

import com.atymtay.spring.course_project.entities.Users;
import com.atymtay.spring.course_project.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<Users> getAllUsers();

    void saveUser(Users user);

    Optional<Users> getUser(Long id);

    void deleteUser(Long id);
}
