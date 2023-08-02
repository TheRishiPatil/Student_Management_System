package com.rishi.spring.boot.sms.service;

import java.util.List;

import com.rishi.spring.boot.sms.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);

}
