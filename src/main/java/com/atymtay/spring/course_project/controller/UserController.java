package com.atymtay.spring.course_project.controller;

import com.atymtay.spring.course_project.entities.Users;
import com.atymtay.spring.course_project.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("\nAdd default user!");
        Users admin = new Users(null,"Bakbergen", "Atymtay", "atymtaevbak@bk.ru", "23434534534");
        usersService.saveUser(admin);
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("\nClean up db from users!");

        List<Users> usersList = usersService.getAllUsers();

        usersList.forEach(user -> usersService.deleteUser(user.getId()));


    }

    @GetMapping("/")
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }
}
