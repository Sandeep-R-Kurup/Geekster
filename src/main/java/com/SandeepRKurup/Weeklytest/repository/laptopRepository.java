package com.SandeepRKurup.Weeklytest.repository;

import com.SandeepRKurup.Weeklytest.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface laptopRepository extends JpaRepository<Laptop, Integer> {
}
