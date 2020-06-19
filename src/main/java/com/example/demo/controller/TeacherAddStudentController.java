package com.example.demo.controller;

import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@ComponentScan({"com.example.demo.service"})
@MapperScan("com.example.demo.mapper")
@Controller
public class TeacherAddStudentController {
    @Resource
    private  TeacherService teacherService;

    @RequestMapping(value = "teacher_add_student")
    public String addStudent(@RequestParam("student_name") String student_name,
                              HttpServletRequest request) {

        String teacher_name = (String) request.getSession().getAttribute("teacher_name");

        Teacher teacher = new Teacher(teacher_name);
        teacher.setTeacher_name(teacher_name);

        teacherService.AddStudent(teacher, student_name);

        return "redirect:/teacher_student_list";
    }
}
