package com.atymtay.spring.course_project.repository;


import java.util.List;
import java.util.Optional;

public interface GenerallRepository<T> {

    List<T> getAll();

    Optional<T> getById(Long id);

    void deleteById(Long id);

    Optional<T> getByName(String name);

    void save(T object);

    void update(T object);


}
