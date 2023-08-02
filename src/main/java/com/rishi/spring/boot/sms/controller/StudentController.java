package com.rishi.spring.boot.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rishi.spring.boot.sms.entity.Student;
import com.rishi.spring.boot.sms.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService service;
	
	@GetMapping("/students")
	public String listOfStudents(Model model) {
		model.addAttribute("students", service.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		model.addAttribute("student", service.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable long id, Model model, @ModelAttribute("student") Student student) {
		// get student database from id
		Student currStudent = service.getStudentById(id);
		currStudent.setId(id);
		currStudent.setFirstName(student.getFirstName());
		currStudent.setLastName(student.getLastName());
		currStudent.setEmail(student.getEmail());
		
		service.updateStudent(currStudent);
		
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudentById(id);
		return "redirect:/students";
	}
}
