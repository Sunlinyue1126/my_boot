package com.firstdevelop.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstdevelop.boot.entity.Student;
import com.firstdevelop.boot.form.StudentForm;
import com.firstdevelop.boot.mapper.StudentMapper;

@Service
public class StudentService {
	@Autowired
	private StudentMapper studentmapper;
	public List<Student> searchAll(){
		return studentmapper.searchAll();
	}

public void insert(StudentForm form) {
	Student student = new Student();
	
	student.setName(form.getName());
	student.setAge(form.getAge());
	student.setScore(form.getScore());
	student.setAddress(form.getAddress());
	student.setStuClass(form.getStuClass());
	
	studentmapper.insert(student);
}
}
