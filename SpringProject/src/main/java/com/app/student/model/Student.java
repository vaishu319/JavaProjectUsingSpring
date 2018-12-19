package com.app.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

import com.app.student.validator.NameStarts;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Name is a required field and it cannot be blank")
	
	@NameStarts(message = "Name Should Start with Admin ")
	private String firstName;
	private String middleName;
	private String lastName;
	private Programs programs;
  
	public Student() {}

	public int getId() {
		return id;
	} 

	public void setId(int id) {
	this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Programs getPrograms() {
		return programs;
	}

	public void setPrograms(Programs programs) {
		this.programs = programs;
	}

	public Student(int id, String firstName, String middleName, String lastName, Programs programs) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.programs = programs;
	}

}
