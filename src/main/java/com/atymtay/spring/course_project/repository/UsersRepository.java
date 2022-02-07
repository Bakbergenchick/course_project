package com.atymtay.spring.course_project.repository;

import com.atymtay.spring.course_project.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
