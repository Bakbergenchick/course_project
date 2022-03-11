package com.atymtay.spring.course_project.service;


import java.util.List;
import java.util.Optional;

public interface GenerallService<T> {

    List<T> getAll();

    void save(T object);

    void update(T object);

    Optional<T> getById(Long id);

    void deleteById(Long id);


}
