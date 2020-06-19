package com.example.demo.controller;

import com.example.demo.entity.Homework;
import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ComponentScan({"com.example.demo.service"})
@MapperScan("com.example.demo.mapper")
@Controller
public class TeacherHomeworkListController {
    @Resource
    private TeacherService teacherService;

    @RequestMapping(value = "teacher_homework_list")
    public String getHomeworkList(Model model,
                                  HttpServletRequest request) {

        String teacher_name = (String) request.getSession().getAttribute("teacher_name");
        Teacher teacher = new Teacher(teacher_name);
        teacher.setTeacher_name(teacher_name);

        List<Homework> homework_list = teacherService.QueryHomework(teacher);
        model.addAttribute("homework_list", homework_list);

        return "teacher_homework";
    }
}
