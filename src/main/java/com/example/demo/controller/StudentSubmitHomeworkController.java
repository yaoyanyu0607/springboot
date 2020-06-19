package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.entity.Submit;
import com.example.demo.service.StudentService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ComponentScan({"com.example.demo.service"})
@MapperScan("com.example.demo.mapper")
@Controller
public class StudentSubmitHomeworkController {
    @Resource
    private StudentService studentService;

    @RequestMapping("student_submit")
    public String submitHomework(@RequestParam("homework_title") String homework_title,
                               @RequestParam("teacher_name") String teacher_name,
                               @RequestParam("content") String content,
                               HttpServletRequest request) {

        String student_name = (String) request.getSession().getAttribute("student_name");

        Student student = new Student(student_name);
        student.setStudent_name(student_name);

        boolean no_submit = true;
        List<Submit> submitList = studentService.QuerySubmits();
        for(Submit submit: submitList) {
            if((submit.getHomework_title().equals(homework_title)) && (submit.getTeacher_name().equals(teacher_name)) && (submit.getStudent_name().equals(student_name))) {
                no_submit = false;
                break;
            }else { }
        }

        if(no_submit) {
            studentService.InsertSubmit(homework_title, teacher_name, student, content);
        }else {
            studentService.UpdateSubmit(homework_title, teacher_name, student, content);
        }

        return "redirect:/student_homework_list";
    }
}
