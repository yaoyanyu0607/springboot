package com.example.demo.controller;

import com.example.demo.entity.Homework;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ComponentScan({"com.example.demo.service"})
@MapperScan("com.example.demo.mapper")
@Controller
public class StudentHomeworkListController {
    @Resource
    private StudentService studentService;

    @RequestMapping(value = "student_homework_list")
    public String getHomework(HttpServletRequest request) {

        String student_name = (String) request.getSession().getAttribute("student_name");
        Student student = new Student(student_name);
        student.setStudent_name(student_name);

        List<Homework> homework_list = studentService.QueryHomework(student);
        request.setAttribute("homework_list", homework_list);

        return "student_submit";
    }
}
