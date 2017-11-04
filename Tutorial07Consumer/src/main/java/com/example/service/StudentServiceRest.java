package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.example.dao.StudentDAO;
import com.example.model.StudentModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("StudentDAO")
@Primary
public class StudentServiceRest implements StudentService
{
    @Autowired
    private StudentDAO studentDAO;


    @Override
    public StudentModel selectStudent (String npm)
    {
        log.info ("Rest - select student with npm {}", npm);
        return studentDAO.selectStudent (npm);
    }
    
    @Override
    public List<StudentModel> selectAllStudents ()
    {
    	log.info ("Rest - select all");
    	return studentDAO.selectAllStudents();
    }


    @Override
    public void addStudent (StudentModel student)
    {
     
    }


    @Override
    public void deleteStudent (String npm)
    {
    	
    }
    
    public void updateStudent(StudentModel student) {
    	
    }

}
