package com.atymtay.spring.course_project.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
abstract class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    private double rating;

    public Course(String name, int price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

}
