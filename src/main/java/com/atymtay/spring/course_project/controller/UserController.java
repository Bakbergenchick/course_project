package com.atymtay.spring.course_project.controller;

import com.atymtay.spring.course_project.entities.Users;
import com.atymtay.spring.course_project.exception.CustomErrorException;
import com.atymtay.spring.course_project.service.impls.jpaServiceImpls.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/user")
    public ResponseEntity<List<Users>> getAllUsers(){

        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/user/{rID}")
    public ResponseEntity<Users> getResponseUser(
            @PathVariable Long rID,
            BindingResult brs
    ){
        if(!brs.hasFieldErrors()){
            return new ResponseEntity<>(userService.getById(rID).get(), HttpStatus.OK);
        }

        throw new CustomErrorException(
                HttpStatus.BAD_REQUEST,
                "Incorrect path",
                (Long) rID
        );

    }


    @PostMapping("/user")
    public ResponseEntity<Void> addUser(
            @RequestBody Users user
    ){
        userService.save(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/user/pageble")
    public ResponseEntity<Page<Users>> getPageofUser(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ){

        return new ResponseEntity<>(userService.getPaged(page,size),HttpStatus.OK);
    }


    @PostMapping("/user/{user_id}/{permanent_id}")
    public ResponseEntity<Void> addPermanentCourseToUser(
            @PathVariable Long permanent_id,
            @PathVariable Long user_id
    ){
        userService.addPermanentCourseToUser(user_id, permanent_id);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/user")
    public ResponseEntity<Void> updateUser(
            @RequestBody Users user
    ){
        URI location = URI.create(String.format("/user/%s", user.getName()));

        userService.update(user);

        return ResponseEntity.created(location).build();
    }



    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long id
    ){

        userService.deleteById(id);

        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);


    }


}
