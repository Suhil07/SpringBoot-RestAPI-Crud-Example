package com.app.suhil.service;

import java.util.List;

import com.app.suhil.entity.Student;

public interface StudentService 
{
     Integer saveStudent(Student s);
     void updateStudent(Student s);
     void deleteStudent(Integer id);
     Student getStudentById(Integer id );
     List<Student> getAllStudents();
     
	
}
