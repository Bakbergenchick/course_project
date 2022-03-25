package com.atymtay.spring.course_project.controller;

import com.atymtay.spring.course_project.entities.Users;
import com.atymtay.spring.course_project.service.impls.jpaServiceImpls.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/user")
    public List<Users> getAllUsers(){

        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public Optional<Users> getUserById(
            @PathVariable Long id
    ){

        return userService.getById(id);
    }

    @PostMapping("/user")
    public String addUser(
            @RequestBody Users user
    ){

        userService.save(user);

        return "Saved!";
    }

    @PostMapping("/user/{user_id}/{permanent_id}")
    public String addPermanentCourseToUser(
            @PathVariable Long permanent_id,
            @PathVariable Long user_id
    ){
        userService.addPermanentCourseToUser(user_id, permanent_id);

        return "PermanentCourse was added!";

    }

    @PutMapping("/user")
    public String updateUser(
            @RequestBody Users user
    ){

        userService.update(user);

        return "Saved!";
    }


    @DeleteMapping("/user/{id}")
    public String deleteUser(
            @PathVariable Long id
    ){

        userService.deleteById(id);

        return "Deleted!";
    }


}
