package com.example.studentManagement.service;

import java.util.List;

import com.example.studentManagement.model.Student;

public interface StudentService {
        Student saveStudent(Student student);
        List<Student> getAllStudent();
        Student getStudentById(Long id);
        Student updateStudent(Student student,Long id);
        void deleteStudent(Long id);
        List<Student> getStudentByYearOfEnrollment(int yearOfEnrollment);
        String getDepartmentById(Long id);
        void removeStudentByYearOfEnrollment(int yearOfEnrollment);
}
