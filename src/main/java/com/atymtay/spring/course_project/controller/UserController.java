package com.atymtay.spring.course_project.controller;

import com.atymtay.spring.course_project.entities.LiveCourse;
import com.atymtay.spring.course_project.entities.PermanentCourse;
import com.atymtay.spring.course_project.entities.Users;
import com.atymtay.spring.course_project.service.impls.hibernateServiceImpls.HibUserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final HibUserServiceImpl hibUserService;

    @GetMapping("/user")
    public List<Users> getAllUsers(){

        return hibUserService.getAll();
    }

    @GetMapping("/user/{id}")
    public Optional<Users> getUserById(
            @PathVariable Long id
    ){

        return hibUserService.getById(id);
    }

    @PostMapping("/user")
    public String addUser(
            @RequestBody Users user
    ){

        hibUserService.save(user);

        return "Saved!";
    }

    @PostMapping("/user/{user_id}/{permanent_id}")
    public String addPermanentCourseToUser(
            @PathVariable Long permanent_id,
            @PathVariable Long user_id
    ){
        hibUserService.addPermanentCourseToUser(user_id, permanent_id);

        return "PermanentCourse was added!";

    }

    @PutMapping("/user")
    public String updateUser(
            @RequestBody Users user
    ){

        hibUserService.update(user);

        return "Saved!";
    }


    @DeleteMapping("/user/{id}")
    public String deleteUser(
            @PathVariable Long id
    ){

        hibUserService.deleteById(id);

        return "Deleted!";
    }


}
