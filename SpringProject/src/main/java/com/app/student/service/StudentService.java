package com.app.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.student.dao.StudentRepository;
import com.app.student.model.Student;

import javassist.NotFoundException;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	///////// GET //////////////
	public List<Student> findAll() throws Exception {

		return studentRepository.findAll();
	}
	
	///////////FindOne //////////////
	
	public Student findOne(int id) throws Exception {
		 
		return studentRepository.findOne(id);
		
	}
	
	

	//////// POST ////////////////////
	public Student save(Student student) {

		return studentRepository.save(student);

	}

	/////// DELETE //////////
	public void delete(int id) throws Exception  {
      
		Student studentdb=studentRepository.findOne(id);
		
		if(studentdb == null) {
			
			throw new NotFoundException("Author with id " + id + " Not Found");
		}
	   studentRepository.delete(studentdb);

	} 

	///////// UPDATE /////////////////////
	public Student update(Student student) {

		return studentRepository.save(student);
	}
	
	
	
	

}
