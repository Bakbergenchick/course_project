package com.atymtay.spring.course_project.repository;

import com.atymtay.spring.course_project.entities.LiveCourse;
import com.atymtay.spring.course_project.entities.Users;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

//@NoArgsConstructor
//public class DBManager {
//    private static final List<Users> userlist = new ArrayList<>();
//    private static final List<LiveCourse> livecourses = new ArrayList<>();
//
//    private static Long userId = 1L;
//    private static Long courseId = 1L;
//
//    static {
//        userlist.add(new Users(userId++, "Bakbergen", "Atymtay", "w32423#awd.com", "23423" ));
//        userlist.add(new Users(userId++, "Kayrat", "Kuanyzhev", "3453@#.com", "345324"));
//
//        livecourses.add(new LiveCourse(courseId++, "C++", 2344, 4.5, "2021/20/12", "2021/15/13"));
//        livecourses.add(new LiveCourse(courseId++, "Java", 4564, 4.78, "2021/20/12", "2021/15/13"));
//    }
//
//    public List<Users> getUserlist() {
//        return userlist;
//    }
//
//    public List<LiveCourse> getLivecourses() {
//        return livecourses;
//    }
//
//    public Users getUser(Long id) {
//        return userlist.stream()
//                .filter(u -> u.getId().equals(id))
//                .findFirst().get();
//    }
//
//    public Users getUserByName(String name) {
//        return userlist.stream()
//                .filter( l -> l.getName().equals(name))
//                .findFirst().get();
//    }
//
//    public LiveCourse getLiveCourse(Long id){
//        return livecourses.stream()
//                .filter( l -> l.getId().equals(id))
//                .findFirst().get();
//    }
//
//    public void addUser(Users user){
//        user.setId(userId++);
//        userlist.add(user);
//    }
//
//    public void addLiveCourse(LiveCourse liveCourse){
//        liveCourse.setId(courseId++);
//        livecourses.add(liveCourse);
//    }
//
//    public void deleteUser(Long id){
//        userlist.remove(id);
//    }
//
//    public void deleteCourse(Long id){
//        livecourses.remove(id);
//    }
//}