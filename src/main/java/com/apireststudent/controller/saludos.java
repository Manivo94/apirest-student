package com.apireststudent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class saludos {

	@GetMapping(value = "/")
	public String saludo() {
		return "Soy un controlador";
	}
}
