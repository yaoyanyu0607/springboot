package com.example.demo.mapper;

import com.example.demo.entity.Homework;
import com.example.demo.entity.Student;
import com.example.demo.entity.Submit;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Insert("INSERT INTO STUDENT VALUES (#{student.student_name})")
    void InsertStudent(@Param("student") Student student);

    @Select("SELECT * FROM HOMEWORK WHERE HOMEWORK.TEACHER_NAME IN (SELECT TEACH.TEACHER_NAME FROM TEACH WHERE STUDENT_NAME=#{student.student_name})")
    List<Homework> QueryHomework(@Param("student") Student student);

    @Select("SELECT * FROM SUBMIT")
    List<Submit> QuerySubmits();

    @Insert("INSERT INTO SUBMIT VALUES (#{homework_title}, #{teacher_name}, #{student.student_name}, #{content})")
    void InsertSubmit(@Param("homework_title") String homework_title, @Param("teacher_name") String teacher_name, @Param("student") Student student, @Param("content") String content);

    @Update("UPDATE SUBMIT SET CONTENT=#{content} WHERE HOMEWORK_TITLE=#{homework_title} AND TEACHER_NAME=#{teacher_name} AND STUDENT_NAME=#{student.student_name}")
    void UpdateSubmit(@Param("homework_title") String homework_title, @Param("teacher_name") String teacher_name, @Param("student") Student student, @Param("content") String content);
}
