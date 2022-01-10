package com.gaganalearning.sts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gaganalearning.sts.entities.Student;
import com.gaganalearning.sts.services.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//handler method 
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("students/new")
	public String newStudent(Model model) {
		Student newStudent = new Student();
		model.addAttribute("newStudent", newStudent);
		return "newStudent";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("newStudent") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id,Model model) {
		model.addAttribute("existingStudent",studentService.getStudentById(id));
		return "editStudent";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("existingStudent") Student existingStudent,Model model) {
		Student tobeUpdated = studentService.getStudentById(id);
		tobeUpdated.setFirstName(existingStudent.getFirstName());
		tobeUpdated.setLastName(existingStudent.getLastName());
		tobeUpdated.setEmail(existingStudent.getEmail());
		tobeUpdated.setId(existingStudent.getId());
		studentService.updateStudent(tobeUpdated);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
	

}
