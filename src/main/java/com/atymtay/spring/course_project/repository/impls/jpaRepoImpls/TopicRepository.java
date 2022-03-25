package com.atymtay.spring.course_project.repository.impls.jpaRepoImpls;

import com.atymtay.spring.course_project.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}
