package com.example.demo.controller;

import com.example.demo.entity.Homework;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.service.StudentService;
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

@Controller
@ComponentScan({"com.example.demo.service"})
@MapperScan("com.example.demo.mapper")
public class IndexController {
    @Resource
    private StudentService studentService;

    @Resource
    private TeacherService teacherService;

    @RequestMapping(value = "index")
    public String Login(@RequestParam("login_name") String login_name,
                        @RequestParam("login_identity") String login_identity,
                        Model model,
                        HttpServletRequest request) {

        if(login_identity.equals("学生")) {
            request.getSession().setAttribute("student_name", login_name);

            Student student = new Student(login_name);
            student.setStudent_name(login_name);

            List<Homework> homework_list = studentService.QueryHomework(student);
            request.setAttribute("homework_list", homework_list);

            return "student_submit";
        }else {
            request.getSession().setAttribute("teacher_name", login_name);

            Teacher teacher = new Teacher(login_name);
            teacher.setTeacher_name(login_name);

            List<Homework> homework_list = teacherService.QueryHomework(teacher);
            model.addAttribute("homework_list", homework_list);

            return "teacher_homework";
        }
    }

    @RequestMapping(value = "login_to_register")
    public String LoginToRegister() {
        return "register";
    }
}
