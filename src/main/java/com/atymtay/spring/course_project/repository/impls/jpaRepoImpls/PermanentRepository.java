package com.atymtay.spring.course_project.repository.impls.jpaRepoImpls;

import com.atymtay.spring.course_project.entities.PermanentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PermanentRepository extends JpaRepository<PermanentCourse, Long> {

//    @Query(value = "select * from PermanentCourse where price > :price",nativeQuery = true)
    List<PermanentCourse> getPermanentCoursesByPriceGreaterThan(int price);
}
