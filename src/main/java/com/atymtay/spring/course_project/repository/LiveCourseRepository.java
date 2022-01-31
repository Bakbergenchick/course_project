package com.atymtay.spring.course_project.repository;


import com.atymtay.spring.course_project.entities.LiveCourse;
import com.atymtay.spring.course_project.service.impls.LiveCourseServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LiveCourseRepository extends JpaRepository<LiveCourse, Long> {

}
