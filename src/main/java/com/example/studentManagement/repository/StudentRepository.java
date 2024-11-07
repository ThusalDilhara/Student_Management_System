package com.example.studentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentManagement.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    

}
