package com.example.studentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentManagement.model.Student;
import com.example.studentManagement.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    
  @Autowired
  private StudentService studentService;

  @PostMapping("/save")
  public ResponseEntity<Student> saveStudent(@RequestBody Student student)
  {
    return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);
  }

  @GetMapping("/getDetails")
  public List<Student> getAllStudent()
  {
    return studentService.getAllStudent();
  }

  @GetMapping("/getDetails/{id}")
  public ResponseEntity<Student> getStudentById(@PathVariable Long id)
  {
    return new ResponseEntity<Student>(studentService.getStudentById(id),HttpStatus.OK);
  }
  
  @PutMapping("/updateStudent/{id}")
  public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student student)
  {
     return new ResponseEntity<Student>(studentService.updateStudent(student, id),HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteEmployee(@PathVariable Long id)
  {
    studentService.deleteStudent(id);
    return new ResponseEntity<String>("Student deleted successfully",HttpStatus.OK);
  }


}
