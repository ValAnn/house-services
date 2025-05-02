package com.example.house_services.repositories;

import com.example.house_services.models.Operator;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Long> {
    // Поиск по ФИО (с игнорированием регистра)
    List<Operator> findByFullNameContainingIgnoreCase(String namePart);
}