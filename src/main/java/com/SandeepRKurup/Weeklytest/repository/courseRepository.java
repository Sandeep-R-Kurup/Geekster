package com.SandeepRKurup.Weeklytest.repository;

import com.SandeepRKurup.Weeklytest.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseRepository extends JpaRepository<Course, Integer> {
}
