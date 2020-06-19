package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@ComponentScan({"com.example.demo.service"})
@MapperScan("com.example.demo.mapper")
@Controller
public class RegisterController {
    @Resource
    private StudentService studentService;

    @Resource
    private TeacherService teacherService;

    @RequestMapping("register")
    public String Register(@RequestParam(value = "register_name") String register_name,
                           @RequestParam(value = "register_identity") String register_identity) {

        if(register_identity.equals("学生")) {
            Student student = new Student(register_name);
            student.setStudent_name(register_name);

            studentService.InsertStudent(student);
        }else {
            Teacher teacher = new Teacher(register_name);
            teacher.setTeacher_name(register_name);

            teacherService.AddTeacher(teacher);
        }

        return "index";
    }
}
