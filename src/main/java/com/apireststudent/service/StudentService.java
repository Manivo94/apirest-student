package com.apireststudent.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.apireststudent.entity.Student;
import com.github.javafaker.Faker;

@Service
public class StudentService {

	@Autowired
	private Faker faker;
	
	List<Student> students = new ArrayList<>();
	
	@PostConstruct // Indicar que este metodo tenga prioridad de inicializar cada vez que sea ejecutado
	public void init() {
		for(int i = 0; i<10; i++) {
			students.add((new Student( 
					//id
					faker.idNumber().invalid(),
					//Nombre
					faker.pokemon().name(),
					//Apellido
					faker.name().lastName(),
					//Edad
					faker.number().digit(),
					//Sexo
					faker.demographic().sex(),
					//Correo
					faker.internet().safeEmailAddress(),
					//Matricula
					faker.idNumber().ssnValid()
					)));
		}
	}
	
	public List<Student> getStudent(){
		return students;
	}
	
	//Buscar por nombre
	public Student getStudentByName(String name) {
		return students.stream().filter(u -> u.getName().equals(name)).findAny().orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,
				String.format("Studen %s not found", name)));
	}
	
	//Crear estudiante
		public Student createStudent(Student student) {
			if(students.stream().anyMatch(u -> u.getName().equals(student.getName()))) {
				throw new ResponseStatusException(HttpStatus.CONFLICT,
				String.format("Student %s Already Exists", student.getName()));
			}
			students.add(student);
			return student;
		}
}
