package com.gaganalearning.sts.services;

import java.util.List;

import com.gaganalearning.sts.entities.Student;

public interface StudentService {
	
	public List<Student> getAllStudents();
	public Student saveStudent(Student student);
	public Student getStudentById(Long id);
	public Student updateStudent(Student student);
	public void deleteStudent(Long id);

}
