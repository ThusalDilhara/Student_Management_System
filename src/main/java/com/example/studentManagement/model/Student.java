package com.example.studentManagement.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(uniqueConstraints ={@UniqueConstraint(columnNames = {"email Id"})},name="Student")

public class Student {
      
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String lastName;
  @Column(name="Email",nullable = false)
  private String email;
  private String department;
  private int yearOfEnrollment;
  
  

 



}
