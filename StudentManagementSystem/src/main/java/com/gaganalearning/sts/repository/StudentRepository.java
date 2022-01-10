package com.gaganalearning.sts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaganalearning.sts.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
