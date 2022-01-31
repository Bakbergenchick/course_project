package com.atymtay.spring.course_project.repository;

import com.atymtay.spring.course_project.entities.PermanentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermanentRepository extends JpaRepository<PermanentCourse, Long> {
}
