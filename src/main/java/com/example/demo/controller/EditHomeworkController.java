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
public class EditHomeworkController {
    @RequestMapping("edit_homework")
    public String getContent(@RequestParam("homework_title") String homework_title,
                             @RequestParam("teacher_name") String teacher_name,
                             Model model) {

        model.addAttribute("homework_title", homework_title);
        model.addAttribute("teacher_name", teacher_name);

        return "edit_homework";
    }
}