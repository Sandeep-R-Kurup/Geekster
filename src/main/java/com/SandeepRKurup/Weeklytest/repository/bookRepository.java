package com.SandeepRKurup.Weeklytest.repository;

import com.SandeepRKurup.Weeklytest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookRepository extends JpaRepository<Book, Integer> {
}
