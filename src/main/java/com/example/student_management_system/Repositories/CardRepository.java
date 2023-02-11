package com.example.student_management_system.Repositories;

import com.example.student_management_system.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {

}
