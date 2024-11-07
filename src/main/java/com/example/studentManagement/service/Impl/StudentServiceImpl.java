package com.example.studentManagement.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentManagement.model.Student;
import com.example.studentManagement.repository.StudentRepository;
import com.example.studentManagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired 
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
       Optional<Student> student=studentRepository.findById(id);
       if(student.isPresent())
       {
        return student.get();
       }
       else{
        throw new RuntimeException();
       }
    }

    @Override
    public Student updateStudent(Student student, Long id) {
      Student existingStudent=studentRepository.findById(id).orElseThrow(
        ()->new RuntimeException()
      );
      existingStudent.setFirstName(student.getFirstName());
      existingStudent.setLastName(student.getLastName());
      existingStudent.setEmail(student.getEmail());
      existingStudent.setDepartment(student.getDepartment());

      studentRepository.save(existingStudent);
      return existingStudent;
          
    }

    @Override
    public void deleteStudent(Long id) {
       studentRepository.findById(id).orElseThrow(
        ()-> new RuntimeException()
       );
       studentRepository.deleteById(id);
    }

    
  

}
