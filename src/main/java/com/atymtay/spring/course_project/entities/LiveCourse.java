package com.atymtay.spring.course_project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LiveCourse extends Course{

    private String startDate;
    private String endDate;

    public LiveCourse(Long id, String name, int price, double rating, String startDate, String endDate) {
        super(id, name, price, rating);
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
