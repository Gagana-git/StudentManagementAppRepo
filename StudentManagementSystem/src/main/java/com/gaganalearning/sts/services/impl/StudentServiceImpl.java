package com.gaganalearning.sts.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gaganalearning.sts.entities.Student;
import com.gaganalearning.sts.repository.StudentRepository;
import com.gaganalearning.sts.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	StudentRepository studentRepo;
	

	public StudentServiceImpl(StudentRepository studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}


	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}


	@Override
	public Student getStudentById(Long id) {
		return studentRepo.findById(id).get();
	}


	@Override
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}


	@Override
	public void deleteStudent(Long id) {
		studentRepo.deleteById(id);		
	}

}
