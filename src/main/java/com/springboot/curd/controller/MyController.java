package com.springboot.curd.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.curd.entities.Student;
import com.springboot.curd.services.StudentService;

@RestController
public class MyController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public List<Student> getStudents() {
		try {
			return studentService.getStudents();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@GetMapping("/students/{student_id}")
	public Optional <Student> getStudent(@PathVariable String student_id) {
		try {
		
			return studentService.getStudent(Long.parseLong(student_id));
			
		
		} catch (Exception e) {
			System.out.println(e);
			return Optional.empty();
		}
	}

	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		try {
			return studentService.addStudent(student);				
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student){
		try {
			 
				return studentService.updateStudent(student);				
			 
			
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@DeleteMapping("/students/{student_id}")
	public void deleteStudent(@PathVariable String student_id){
		try{
			 
			studentService.deleteStudent(Long.parseLong(student_id));			
			 
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
