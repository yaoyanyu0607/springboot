package com.example.demo.service;

import com.example.demo.mapper.TeacherMapper;
import com.example.demo.entity.Homework;
import com.example.demo.entity.Student;
import com.example.demo.entity.Submit;
import com.example.demo.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("teacherStudent")
public class TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Transactional
    public void AddTeacher(Teacher teacher) {
        teacherMapper.AddTeacher(teacher);
    }

    @Transactional
    public List<Homework> QueryHomework(Teacher teacher) {
        List<Homework> homeworkList = teacherMapper.QueryHomework(teacher);
        return homeworkList;
    }

    @Transactional
    public void AddHomework(Teacher teacher, String homework_title) {
        teacherMapper.AddHomework(teacher, homework_title);
    }

    @Transactional
    public void AddStudent(Teacher teacher, String student_name) {
        teacherMapper.AddStudent(teacher, student_name);
    }

    @Transactional
    public List<Student> QueryStudent(Teacher teacher) {
        return teacherMapper.QueryStudent(teacher);
    }

    public List<Submit> QuerySubmit(String homework_title, Teacher teacher) {
        return teacherMapper.QuerySubmit(homework_title, teacher);
    }

    @Transactional
    public String CheckContent(String homework_title, Teacher teacher, String student_name) {
        return teacherMapper.CheckContent(homework_title, teacher, student_name);
    }
}
