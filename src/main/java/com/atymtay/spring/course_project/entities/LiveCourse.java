package com.atymtay.spring.course_project.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LiveCourse extends Course{

    private String startDate;
    private String endDate;

    public LiveCourse(Long id, String name, int price, double rating, String startDate, String endDate) {
        super(id, name, price, rating);
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
