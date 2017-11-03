package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.model.StudentModel;
import com.example.service.CourseService;
import com.example.service.StudentService;

@Controller
public class StudentController
{
    @Autowired
    StudentService studentDAO;


    @RequestMapping("/")
    public String index (Model model)
    {
    	model.addAttribute("title","Home");
        return "index";
    }


    @RequestMapping("/student/add")
    public String add (Model model)
    {
        StudentModel student= new StudentModel();
        model.addAttribute("student", student);
        model.addAttribute("title","Add Student");
    	return "form-add";
    }


    @RequestMapping("/student/add/submit")
    public String addSubmit (StudentModel student)
    {
        studentDAO.addStudent (student);

        return "success-add";
    }


    @RequestMapping("/student/view")
    public String view (Model model,
            @RequestParam(value = "npm", required = false) String npm)
    {
        StudentModel student = studentDAO.selectStudent (npm);

        if (student != null) {
            model.addAttribute ("student", student);
            return "view";
        } else {
            model.addAttribute ("npm", npm);
            return "not-found";
        }
    }


    @RequestMapping("/student/view/{npm}")
    public String viewPath (Model model,
            @PathVariable(value = "npm") String npm)
    {
        StudentModel student = studentDAO.selectStudent (npm);

        if (student != null) {
            model.addAttribute ("student", student);
            return "view";
        } else {
            model.addAttribute ("npm", npm);
            return "not-found";
        }
    }


    @RequestMapping("/student/viewall")
    public String view (Model model)
    {
        List<StudentModel> students = studentDAO.selectAllStudents ();
        model.addAttribute("title","View All Student");
        model.addAttribute ("students", students);
        return "viewall";
    }


    @RequestMapping("/student/delete/{npm}")
    public String delete (Model model, @PathVariable(value = "npm") String npm)
    {
    	StudentModel students = studentDAO.selectStudent(npm);
    	if(students == null) {
    		return "not-found";
    	}
        studentDAO.deleteStudent (npm);
        
        return "delete";
    }
    
    @RequestMapping("/student/update/{npm}")
    public String update(Model model, @PathVariable(value="npm") String npm) {
    	StudentModel students = studentDAO.selectStudent(npm);
    	if(students==null) {
    		return "not-found";
    	}
    	model.addAttribute("students",students);
    	model.addAttribute("title","Edit Students");
    	return "form-update";
    }
//    
//    @RequestMapping(value = "/student/update/submit", method= RequestMethod.POST)
//    public String updateSubmit(@RequestParam(value="npm",required=false) String npm,
//    		@RequestParam(value="name",required=false) String name,
//    		@RequestParam(value="gpa",required=false) double gpa) {
//    	StudentModel students = new StudentModel(npm, name, gpa);
//    	studentDAO.updateStudent(students);
//    	return "success-update";
//    }
    @RequestMapping(value = "/student/update/submit", method= RequestMethod.POST)
    public String updateSubmit(StudentModel students) {
    	studentDAO.updateStudent(students);
    	return "success-update";
    }


}
