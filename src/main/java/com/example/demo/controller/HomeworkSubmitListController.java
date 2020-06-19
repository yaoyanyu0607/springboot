package com.example.demo.controller;

import com.example.demo.entity.Submit;
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
import java.util.List;

@ComponentScan({"com.example.demo.service"})
@MapperScan("com.example.demo.mapper")
@Controller
public class HomeworkSubmitListController {
    @Resource
    private TeacherService teacherService;

    @RequestMapping(value = "homework_submit_list")
    public String getSubmitList(@RequestParam("homework_title") String homework_title,
                                Model model,
                                HttpServletRequest request) {

        String teacher_name = (String) request.getSession().getAttribute("teacher_name");

        Teacher teacher = new Teacher(teacher_name);
        teacher.setTeacher_name(teacher_name);

        List<Submit> submit_list = teacherService.QuerySubmit(homework_title, teacher);
        model.addAttribute("submit_list", submit_list);

        return "homework_student";
    }
}
