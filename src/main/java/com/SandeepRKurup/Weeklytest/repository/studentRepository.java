package com.SandeepRKurup.Weeklytest.repository;

import com.SandeepRKurup.Weeklytest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<Student,Integer> {
}
