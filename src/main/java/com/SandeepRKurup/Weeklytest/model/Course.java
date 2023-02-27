package com.SandeepRKurup.Weeklytest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer course_Id;
    private String title;
    private String description;
    private String duration;


    @ManyToMany(fetch = FetchType.LAZY)
    List<Student> studentList = new ArrayList<>();


}
