package com.atymtay.spring.course_project.service;

import com.atymtay.spring.course_project.entities.LiveCourse;

import java.util.List;
import java.util.Optional;

public interface JDBCCourseService<T> {
    List<T> getAllCourses();

    Optional<T> getCourse(Long id);

    void deleteCourse(Long id);

    Optional<T> getCourseByName(String name);

    void save(T liveCourse);

    void update(T liveCourse);
}
