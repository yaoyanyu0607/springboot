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
public class TeacherAddHomeworkController {
    @Resource
    private TeacherService teacherService;

    @RequestMapping(value = "teacher_add_homework")
    public String addHomework(@RequestParam("homework_title") String homework_title,
                              HttpServletRequest request) {

        String teacher_name = (String) request.getSession().getAttribute("teacher_name");

        Teacher teacher = new Teacher(teacher_name);
        teacher.setTeacher_name(teacher_name);

        teacherService.AddHomework(teacher, homework_title);

        return "redirect:/teacher_homework_list";
    }
}
