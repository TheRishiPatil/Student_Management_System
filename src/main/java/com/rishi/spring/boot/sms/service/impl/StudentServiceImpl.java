package com.rishi.spring.boot.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.spring.boot.sms.entity.Student;
import com.rishi.spring.boot.sms.repository.StudentRepository;
import com.rishi.spring.boot.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository repository;
	
	@Override
	public List<Student> getAllStudents() {
		return repository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	@Override
	public Student getStudentById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Student updateStudent(Student student) {
		return repository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		repository.deleteById(id);		
	}
}
