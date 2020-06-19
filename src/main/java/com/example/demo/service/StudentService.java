package com.example.demo.service;

import com.example.demo.entity.Submit;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.entity.Homework;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Transactional
    public void InsertStudent(Student student) {
        studentMapper.InsertStudent(student);
    }

    @Transactional
    public List<Homework> QueryHomework(Student student) {
        return studentMapper.QueryHomework(student);
    }

    @Transactional
    public List<Submit> QuerySubmits() {
        return studentMapper.QuerySubmits();
    }

    @Transactional
    public void InsertSubmit(String homework_title, String teacher_name, Student student, String content) {
        studentMapper.InsertSubmit(homework_title, teacher_name, student, content);
    }

    @Transactional
    public void UpdateSubmit(String homework_title, String teacher_name, Student student, String content) {
        studentMapper.UpdateSubmit(homework_title, teacher_name, student, content);
    }
}
