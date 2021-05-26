package com.zukalover.secureapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zukalover.secureapp.model.Student;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

	private static final List<Student> STUDENTS = Arrays.asList(
			new Student(1,"Zuka Mochoana"),
			new Student(2,"James Bond"),
			new Student(3,"Zukalover Mzingaye")
			);
	/**
	 * USING THE @PreAuthorize("") to secure API's instead of AntMatchers
	 * 
	 * hasRole('ROLE_')
	 * hasAuthority('permission')
	 * 
	 * @param studentId
	 * @return
	 */
	@GetMapping("/get-student/{studentid}")
	public Student getStudent(@PathVariable("studentid") int studentId)
	{
		return STUDENTS.stream().filter(student -> studentId == student.getStudentId())
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("Illegakl"));
	}
}
