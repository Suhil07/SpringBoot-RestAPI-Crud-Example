package com.app.suhil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.suhil.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> 
{

}
