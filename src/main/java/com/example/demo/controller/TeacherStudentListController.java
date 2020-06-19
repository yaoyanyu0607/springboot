package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ComponentScan({"com.example.demo.service"})
@MapperScan("com.example.demo.mapper")
@Controller
public class TeacherStudentListController {
    @Resource
    private TeacherService teacherService;

    @RequestMapping(value = "teacher_student_list")
    public String getStudent(Model model,
                                  HttpServletRequest request) {

        String teacher_name = (String) request.getSession().getAttribute("teacher_name");
        Teacher teacher = new Teacher(teacher_name);
        teacher.setTeacher_name(teacher_name);

        List<Student> student_list = teacherService.QueryStudent(teacher);
        model.addAttribute("student_list", student_list);

        return "teacher_student";
    }
}
