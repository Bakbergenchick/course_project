package com.atymtay.spring.course_project.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Value("${surname.1}")
    private String surname;

    private String email;

    private String password;

    private static Long defId = 1L;
    private static final String defEmail = "user@domain.com";
    private static final String defName = "User";


    private void initUser() {
        System.out.println("Initializing bean....");

        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);


        if(id == null){
            System.out.println("Using autoincrement id!");
            this.id = defId++;
        }

        if (!matcher.matches()){
            line();
            System.out.println("Using default email!");
            this.email = defEmail;
            line();
        }
        if(name == null){
            line();
            System.out.println("Using default name!");
            this.name = defName;
            line();
        }
        if(password == null) this.password = "";

        if(password.length() < 8){
//            password = "";
            line();
            System.out.println("Using password extension!");
            this.password += "_blablabla";
            line();
        }


    }

    public void line(){
        System.out.println("<--------------------------------->");
    }

    private void destroyUser() {
        System.out.printf("Spring container destroyed! Users with id=%s clean up\n", id);
    }

}
