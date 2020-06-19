package com.example.demo.controller;

import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@ComponentScan({"com.example.demo.service"})
@MapperScan("com.example.demo.mapper")
@Controller
public class TeacherHomeworkContentController {
    @Resource
    private TeacherService teacherService;

    @RequestMapping("homework_content")
    public String getContent(@RequestParam("homework_title") String homework_title,
                             @RequestParam("student_name") String student_name,
                             Model model,
                             HttpServletRequest request) {

        String teacher_name = (String) request.getSession().getAttribute("teacher_name");
        Teacher teacher = new Teacher(teacher_name);
        teacher.setTeacher_name(teacher_name);

        String content = teacherService.CheckContent(homework_title, teacher, student_name);
        model.addAttribute("homework_title", homework_title);
        model.addAttribute("student_name", student_name);
        model.addAttribute("content", content);

        return "homework_content";
    }
}
