package com.app.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.student.dao.StudentRepository;
import com.app.student.model.Student;
import com.app.student.service.StudentService;

@RestController
@RequestMapping("student")
@CrossOrigin(origins = { "http://localhost:4200" })
public class StudentController {

	// @RequestMapping(method=RequestMethod.GET)
	// public String getStudent() {
	//
	// return "Welcome to my New Spring Project";
	//
	// }

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentService studentService;

	/*
	 * 
	 * @RequestMapping(method = RequestMethod.GET) public Student getStudent() {
	 * 
	 * Student student = new Student(); student.setId(1);
	 * student.setFirstName("Vishnavi"); student.setMiddleName("Reddy"); //We generated
	 * student objects here student.setLastName("Bhavanam"); student.setAge(35);
	 * 
	 * return student; // When we run this code we see that it returns the JSON
	 * Object. }
	 * 
	 * 
	 * @RequestMapping(method = RequestMethod.GET, value="/all") public
	 * List<Student>getAll() {
	 * 
	 * List<Student>students = new ArrayList<>();
	 * 
	 * Student student = new Student(); student.setId(1);
	 * student.setFirstName("Vishnavi"); student.setMiddleName("Reddy");
	 * student.setLastName("Bhavanam"); student.setAge(35); students.add(student);
	 * //Here, we generated list of student objects Student student1 = new
	 * Student(); student1.setId(2); student1.setFirstName("Rajashekhar");
	 * student1.setMiddleName("Reddy"); student1.setLastName("Bhavanam");
	 * student1.setAge(40); students.add(student1);
	 * 
	 * return students;
	 * 
	 * }
	 */

	/*
	 * @RequestMapping(method = RequestMethod.POST) public
	 * ResponseEntity<HttpStatus> create(@RequestBody Student student) {
	 * //@RequestBody ---whenever u post the request it will take the JSON data
	 * //and it will convert it to Author Object. studentrepository.save(student);
	 * //Here, we are creating a Student thats the Reason y we are using POST return
	 * new ResponseEntity<HttpStatus>(HttpStatus.CREATED); }
	 */

	///////////////////////////////////////////////////////////////////////////////////////

	//@PostMapping
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Student> create(@RequestBody @Valid Student student) {
		System.out.println(student);
		return new ResponseEntity<Student>(studentService.save(student), HttpStatus.CREATED);
	}

	///////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(method = RequestMethod.GET)
	public List<Student> getAll() throws Exception {

		return studentService.findAll();
	}
 
	///////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(method = RequestMethod.PUT)
	// @PutMapping(value="/{Id}")
	public Student update(@RequestBody Student student) {
		return studentService.save(student);
	}
 
	///////////////////////////////////////////////////////////////////////////////////////

	//@RequestMapping(method = RequestMethod.DELETE, value = "/{Id}")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) throws Exception  {
		studentService.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
 
	//////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Student getById(@PathVariable("id") int id) throws Exception {

		return studentService.findOne(id); 

	}

}
