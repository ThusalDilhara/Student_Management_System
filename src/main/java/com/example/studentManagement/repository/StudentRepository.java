package com.example.studentManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.example.studentManagement.model.Student;

import jakarta.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
   List<Student> findByYearOfEnrollment(int yearOfEnrollment);

   @Query("SELECT s.department FROM Student s WHERE s.id = :id")
   String findDepartmentById(Long id);
   
   @Transactional
   @Modifying
   @Query("DELETE FROM Student s WHERE s.yearOfEnrollment = :yearOfEnrollment")
   void deleteByYearOfEnrollment(int yearOfEnrollment);


}
