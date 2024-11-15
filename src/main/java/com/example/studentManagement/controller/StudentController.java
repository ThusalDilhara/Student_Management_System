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

  @GetMapping("/yearOfEnrollment/{yearOfEnrollment}")
  public ResponseEntity<List<Student>> getStudentByYearOfEnrollment(@PathVariable int yearOfEnrollment)
  {
    List<Student> student=studentService.getStudentByYearOfEnrollment(yearOfEnrollment);
    return new ResponseEntity<>(student,HttpStatus.OK);
  }

  @GetMapping("/department/{id}")
  public ResponseEntity<String> getDepartmentById(@PathVariable Long id)
  {
    String departmentName = studentService.getDepartmentById(id);
    if (departmentName != null) {
        return new ResponseEntity<String>(departmentName,HttpStatus.OK);
    } else {
        return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/removeStudent/{yearOfEnrollment}")
  public ResponseEntity<String> deleteStudentByYearOfEnrollment(@PathVariable int yearOfEnrollment)
  {
     studentService.removeStudentByYearOfEnrollment(yearOfEnrollment);
     return ResponseEntity.ok("Students enrolled in " + yearOfEnrollment + " have been removed.");
  }



}
