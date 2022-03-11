package com.atymtay.spring.course_project.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.cache.annotation.EnableCaching;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PermanentCourse extends Course{
    private String releaseDate;

    public PermanentCourse(Long id, String name, int price, double rating, String releaseDate) {
        super(id, name, price, rating);
        this.releaseDate = releaseDate;
    }

    @OneToMany(fetch = FetchType.EAGER,  cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    }, mappedBy = "permanentCourse")
    @JsonManagedReference
    private Set<Topic> topicList = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH
    }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "permanent_user_join",
            joinColumns = @JoinColumn(name = "permanent_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")
    )
    @JsonIgnoreProperties("permanentCourses")
    private Set<Users> usersSet = new HashSet<>();

    public void addTopicToPermanentCourse(Topic topic){
//        if(topicList == null){
//            topicList = new HashSet<>();
//        }

        topic.setPermanentCourse(this);
        topicList.add(topic);
    }


}
