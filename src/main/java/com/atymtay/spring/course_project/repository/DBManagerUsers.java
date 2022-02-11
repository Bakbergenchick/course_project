package com.atymtay.spring.course_project.repository;

import com.atymtay.spring.course_project.entities.Roles;
import com.atymtay.spring.course_project.entities.Users;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@PropertySource("classpath:myConfig.properties")
public class DBManagerUsers {
    private static final List<Users> userlist = new ArrayList<>();

    private static Long Id = 1L;

    static {
        userlist.add(new Users(Id++, "Bakbergen", "Atymtay", "w32423#awd.com", "23423"));
        userlist.add(new Users(Id++, "Kayrat", "Kuanyzhev", "3453@#.com", "345324"));
    }

    public List<Users> getUserlist() {
        return userlist;
    }

    public Users getUser(Long id) {
        return userlist.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst().get();
    }

    public void addUser(Users user){
        user.setId(Id++);
        userlist.add(user);
    }

    public void deleteUser(Long id){
        userlist.remove(id);
    }
}