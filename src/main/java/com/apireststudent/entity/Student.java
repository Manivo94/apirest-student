package com.apireststudent.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	private String Id;
	private String name;
	private String lastName;
	private String edad;
	private String sexo;
	private String email;
	private String tuition;
}
