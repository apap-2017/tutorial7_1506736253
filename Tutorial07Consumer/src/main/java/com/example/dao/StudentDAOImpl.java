package com.example.dao;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.StudentModel;

@Service
public class StudentDAOImpl implements StudentDAO{
	@Autowired
	private RestTemplate restTemplate;
	
	public StudentModel selectStudent(String npm) {
		StudentModel student = restTemplate.getForObject("http://localhost:8080/rest/student/view/"+npm, StudentModel.class);
		return student;
	}

	@Override
	public List<StudentModel> selectAllStudents() {
		// TODO Auto-generated method stub
		ResponseEntity<StudentModel[]> list_student = restTemplate.getForEntity("http://localhost:8080/rest/student/viewall", StudentModel[].class);
		return Arrays.asList(list_student.getBody());
		
	}
	
	


}
