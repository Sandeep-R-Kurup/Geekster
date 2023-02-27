package com.SandeepRKurup.Weeklytest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer book_Id;

    private String title;
    private String author;
    private String description;
    private String price;

    @ManyToOne
    private Student student;
}