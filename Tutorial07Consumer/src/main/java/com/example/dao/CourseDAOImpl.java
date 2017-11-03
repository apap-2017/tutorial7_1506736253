package com.example.dao;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
//
//import java.util.Arrays;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.CourseModel;

@Service
public class CourseDAOImpl implements CourseDAO{
	@Autowired
	private RestTemplate restTemplate;
	
	public CourseModel selectCourse(String id) {
		CourseModel course = restTemplate.getForObject("http://localhost:8080/rest/course/view/"+id, CourseModel.class);
		return course;
	}
//
//	@Override
//	public List<StudentModel> selectAllStudents() {
//		// TODO Auto-generated method stub
//		ResponseEntity<StudentModel[]> list_student = restTemplate.getForEntity("http://localhost:8080/rest/student/viewall", StudentModel[].class);
//		return Arrays.asList(list_student.getBody());
//		
//	}
	
	


}
