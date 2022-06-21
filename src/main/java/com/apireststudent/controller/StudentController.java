package com.apireststudent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apireststudent.entity.Student;
import com.apireststudent.service.StudentService;


@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	//Mostrar todos los estudiantes
	@GetMapping
	public ResponseEntity<List<Student>> getStudentAll(){
		return new ResponseEntity<List<Student>>(studentService.getStudent(),HttpStatus.OK);
	}
	
	//Mostrar por nombre
	@GetMapping(value="/{name}")
	public ResponseEntity<Student> getStudentName(@PathVariable("name")String name){
		return new ResponseEntity<Student>(studentService.getStudentByName(name), HttpStatus.OK);
	}
	
	//Crear estudiante
	@PostMapping
	public ResponseEntity<Student>CreateStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.createStudent(student), HttpStatus.CREATED);
	}
	
	@PutMapping(value="{name}")
	public ResponseEntity<Student> updateStudent(@PathVariable("name")String name,
			@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudent(student, name), HttpStatus.OK);
	}
}
