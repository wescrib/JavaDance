package com.scribnerw.controls;

import java.util.List;

import org.json.simple.JSONObject;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scribnerw.models.User.*;
import com.scribnerw.repos.*;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private InstructorRepo instructorRepo;
	
	@Autowired
	private AdminRepo adminRepo;
	
	
	/*
	 * CREATE ACCOUNTS
	 */
	
	@PostMapping("/new-student")
	public Student createStudent(@RequestBody Student student) {
		student.setPassword(BCrypt.hashpw(student.getPassword(),BCrypt.gensalt()));
		return studentRepo.save(student);
	}
	@PostMapping("/new-instructor")
	public Instructor createInstructor(@RequestBody Instructor instructor) {
		return instructorRepo.save(instructor);
	}
	
	@PostMapping("/new-admin")
	public Administrator createAdmin(@RequestBody Administrator admin) {
		return adminRepo.save(admin);
	}
	
	/*
	 * EDIT USERS
	 */
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student s) {
		return studentRepo.save(s);
	}
	
	@PutMapping("/updateInstructor")
	public Instructor updateInstruct(@RequestBody Instructor i) {
		return instructorRepo.save(i);
	}
	
	@PutMapping("/updateAdmin")
	public Administrator updateStudent(@RequestBody Administrator a) {
		return adminRepo.save(a);
	}
	
	/*
	 * DELETE USERS
	 */
	@DeleteMapping("/delete/student/{id}")
	void deleteStudent(@PathVariable("id") int id) {
		studentRepo.delete(id);
	}
	@DeleteMapping("/delete/admin/{id}")
	void deleteAdmin(@PathVariable("id") int id) {
		adminRepo.delete(id);
	}
	@DeleteMapping("/delete/instructor/{id}")
	void deleteInstructor(@PathVariable("id") int id) {
		instructorRepo.delete(id);
	}
	
	/*
	 * GET ONE
	 */
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable("id") int id) {
		return studentRepo.findOne(id);
	}
	
	@GetMapping("/instructor/{id}")
	public Instructor getInstructor(@PathVariable("id") int id) {
		return instructorRepo.getOne(id);
	}
	
	@GetMapping("/admin/{id}")
	public Administrator getAdmin(@PathVariable("id") int id) {
		return adminRepo.getOne(id);
	}
	
	/*
	 * GET ALL
	 */
	
	@GetMapping("/allStudents")
	public List<Student> getAllStudents(){
		System.out.println("GETTING ALL STUDENTS");
		return (List<Student>) studentRepo.findAll();
	}
	
	@GetMapping("/allInstructors")
	public List<Instructor> getAllInstructors(){
		return instructorRepo.findAll();
	}
	
	@GetMapping("/allAdmins")
	public List<Administrator> getAllAdmins(){
		return adminRepo.findAll();
	}
	
	/*
	 * LOGIN
	 */
	
	@PostMapping("/login")
	public Student loginStudent(@RequestBody JSONObject login) {
		String email = (String) login.get("email");
		String pw = (String) login.get("password");
		Student blankStudent = new Student();
		if(email.equals("") || pw.equals("")) {
			blankStudent.setErrors("Email/Password fields cannot be blank");
			return blankStudent;
		}
		Student student = studentRepo.findByEmail(email);
		if(student == null) {
			blankStudent.setErrors("Email not on record");
			return blankStudent;
			} else {
				if(BCrypt.checkpw(pw, student.getPassword())) {
					return student;
				}
			blankStudent.setErrors("Passwords do not match");
			return blankStudent;
		}
	}
}
