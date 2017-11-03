package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.AppMapper;
import com.example.model.CourseModel;

@Service
public class CourseServiceDatabase implements CourseService
{
    @Autowired
    private AppMapper studentMapper;


    @Override
    public CourseModel selectCourseById(String id)
    {
        return studentMapper.selectCourseById(id);
    }


	@Override
	public List<CourseModel> selectAllCourse() {
		// TODO Auto-generated method stub
		return studentMapper.selectAllCourse();
	}
    
}