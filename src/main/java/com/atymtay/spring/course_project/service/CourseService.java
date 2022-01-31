package com.atymtay.spring.course_project.service;


import java.util.List;
import java.util.Optional;

public interface CourseService<T> {

    List<T> getAllCourses();

    void saveCourse(T course);

    Optional<T> getCourse(Long id);

    void deleteCourse(Long id);

}
