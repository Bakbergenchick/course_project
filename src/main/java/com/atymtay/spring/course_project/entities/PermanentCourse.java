package com.atymtay.spring.course_project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PermanentCourse extends Course{
    private String releaseDate;

    public PermanentCourse(Long id, String name, int price, double rating, String releaseDate) {
        super(id, name, price, rating);
        this.releaseDate = releaseDate;
    }
}
