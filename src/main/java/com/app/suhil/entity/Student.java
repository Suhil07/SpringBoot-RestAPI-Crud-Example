package com.app.suhil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="student_info")
public class Student 
{
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="sid")
	 private Integer StdId;
     
     @Column(name="sname")
	 private String stdName;
     
     @Column(name="sgen")
	 private String stdGen;
     
     @Column(name="scourse")
	 private String stdCourse;
     
     @Column(name="saddr")
	 private String stdAddr;
	
}
