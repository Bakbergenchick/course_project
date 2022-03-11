package com.atymtay.spring.course_project.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @Value("${surname.1}")
    private String surname;

    private String email;

    private String password;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH
    }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "permanent_user_join",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name="permanent_id")
    )

    private Set<PermanentCourse> permanentCourses = new HashSet<>();

    public void addPermanentCourseToUser(PermanentCourse permanentCourse){
        permanentCourses.add(permanentCourse);
    }










    //    private static Long defId = 1L;
//    private static final String defEmail = "user@domain.com";
//    private static final String defName = "User";
//
//
//    private void initUser() {
//        System.out.println("Initializing bean....");
//
//        String regex = "^(.+)@(.+)$";
//
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(email);
//
//
//        if(id == null){
//            System.out.println("Using autoincrement id!");
//            this.id = defId++;
//        }
//
//        if (!matcher.matches()){
//            line();
//            System.out.println("Using default email!");
//            this.email = defEmail;
//            line();
//        }
//        if(name == null){
//            line();
//            System.out.println("Using default name!");
//            this.name = defName;
//            line();
//        }
//        if(password == null) this.password = "";
//
//        if(password.length() < 8){
////            password = "";
//            line();
//            System.out.println("Using password extension!");
//            this.password += "_blablabla";
//            line();
//        }
//
//
//    }

//    public void line(){
//        System.out.println("<--------------------------------->");
//    }
//
//    private void destroyUser() {
//        System.out.printf("Spring container destroyed! Users with id=%s clean up\n", id);
//    }

}
