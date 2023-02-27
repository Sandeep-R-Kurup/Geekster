package com.SandeepRKurup.Weeklytest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer laptop_id;
    private String name;
    private String brand;
    private Integer price;

    @OneToOne
    private Student student_Id;
}
