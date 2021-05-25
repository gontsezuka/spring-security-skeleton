package com.zukalover.secureapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zukalover.secureapp.model.Student;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
	
	private static final List<Student> STUDENTS = Arrays.asList(
			new Student(1,"Zuka Mochoana"),
			new Student(2,"James Bond"),
			new Student(3,"Zukalover Mzingaye")
			);
	
	@GetMapping("/get-all")
	public List<Student> getAllStudents()
	{
		return STUDENTS;
	}
	
	@PostMapping("/register")
	public void register(@RequestBody Student student)
	{
		//STUDENTS.add(student);
		System.out.println(student);
	}
	
	@DeleteMapping("/delete/{studentid}")
	public void deleteStudent(@PathVariable("studentid") int studentId)
	{
//		for(Student student: STUDENTS)
//		{
//			if(student.getStudentId() == studentId)
//			{
//				STUDENTS.remove(student);
//			}
//		}
		
		System.out.println(studentId);
	}
	
	@PutMapping("/update/{studentid}")
	public void updateStudent(@PathVariable("studentid")int studentId,@RequestBody Student student)
	{
		System.out.println(student);
	}
}
