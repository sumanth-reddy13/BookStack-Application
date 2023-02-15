package com.example.student_management_system.Repositories;

import com.example.student_management_system.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // we can only use find functions using this quering mechanism. It returns an object || list of Objects.
    Student findByEmail(String email);
}
