package com.example.student_management_system.Repositories;

import com.example.student_management_system.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    public Book findByName(String name);
}
