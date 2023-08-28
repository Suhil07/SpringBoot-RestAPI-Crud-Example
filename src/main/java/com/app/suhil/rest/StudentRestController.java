package com.app.suhil.rest;

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

import com.app.suhil.entity.Student;
import com.app.suhil.exception.StudentNotFoundException;
import com.app.suhil.service.StudentService;

@RestController
@RequestMapping("/v1/api/student")
public class StudentRestController 
{
   @Autowired
   private StudentService service;
   
   @PostMapping("/create")
   public ResponseEntity<String> createStudent(@RequestBody Student student)
   {
	   
	   Integer id = service.saveStudent(student);
	   String msg="Student "+id+"created";
	   return new ResponseEntity<String>(msg,HttpStatus.CREATED);
   }
   
   @GetMapping("/getAll")
   public ResponseEntity<List<Student>> getAllStudent()
   {
	   List<Student> allStudents = service.getAllStudents();
	   return new ResponseEntity(allStudents,HttpStatus.OK);
   }
   
    @GetMapping("/find/{id}")
	public ResponseEntity<Student> getOneStudent(@PathVariable("id") Integer id) 
	{
		ResponseEntity<Student> response = null;
		try
		{
			Student s = service.getStudentById(id);
			response = new ResponseEntity<>(s,HttpStatus.OK);
		} 
		catch (StudentNotFoundException e) 
		{
			e.printStackTrace();
			throw e;
		}
		return response;
	}
    
    @DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer id) 
	{
		ResponseEntity<String> response = null;
		try 
		{
			service.deleteStudent(id);
			response = ResponseEntity.ok("STUDENT '"+id+"' REMOVED");
		} 
		catch (StudentNotFoundException e) 
		{
			e.printStackTrace();
			throw e;
		}
		return response;
	}
   
    @PutMapping("/modify")
	public ResponseEntity<String> updateStudent(@RequestBody Student student)
	{
		ResponseEntity<String> response = null;
		try {
			service.updateStudent(student);
			response = ResponseEntity.ok("STUDENT '"+student.getStdId()+"' UPDATED");
		} 
		catch (StudentNotFoundException e)
		{
			e.printStackTrace();
			throw e;
		}
		return response;
	}
	
}
