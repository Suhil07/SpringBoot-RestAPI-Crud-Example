package com.app.suhil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.suhil.entity.Student;
import com.app.suhil.exception.StudentNotFoundException;
import com.app.suhil.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository repo;

	@Override
	public Integer saveStudent(Student s)
	{
		
        s = repo.save(s);
		return s.getStdId();
	}

	@Override
	public void updateStudent(Student s) 
	{
		if(s.getStdId() == null || !repo.existsById(s.getStdId()))
			throw new StudentNotFoundException("STUDENT '"+s.getStdId()+"' NOT EXIST");
		else
			repo.save(s);
		
	}

	@Override
	public void deleteStudent(Integer id) 
	{
		if(id == null || !repo.existsById(id))
			throw new StudentNotFoundException("STUDENT '"+id+"' NOT EXIST");
		else
			repo.deleteById(id);
		
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> findById = repo.findById(id);
		if(findById.isPresent())
		{
			return findById.get();
		}
		else
		{
			throw new StudentNotFoundException("STUDENT '"+id+"' NOT EXIST");
		}
		
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> list = repo.findAll();
		return list;
		
	}

	
}
