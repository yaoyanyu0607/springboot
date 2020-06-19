package com.example.demo.mapper;

import com.example.demo.entity.Homework;
import com.example.demo.entity.Student;
import com.example.demo.entity.Submit;
import com.example.demo.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Insert("INSERT INTO TEACHER VALUES (#{teacher.teacher_name})")
    void AddTeacher(@Param("teacher") Teacher teacher);

    @Select("SELECT * FROM HOMEWORK WHERE TEACHER_NAME=#{teacher.teacher_name}")
    List<Homework> QueryHomework(@Param("teacher") Teacher teacher);

    @Insert("INSERT INTO HOMEWORK VALUES (#{homework_title}, #{teacher.teacher_name})")
    void AddHomework(@Param("teacher") Teacher teacher, @Param("homework_title") String homework_title);

    @Insert("INSERT INTO TEACH VALUES (#{teacher.teacher_name}, #{student_name})")
    void AddStudent(@Param("teacher") Teacher teacher, @Param("student_name") String student_name);

    @Select("SELECT * FROM TEACH WHERE TEACHER_NAME=#{teacher.teacher_name}")
    List<Student> QueryStudent(@Param("teacher") Teacher teacher);

    @Select("SELECT * FROM SUBMIT WHERE HOMEWORK_TITLE=#{homework_title} and TEACHER_NAME=#{teacher.teacher_name}")
    List<Submit> QuerySubmit(@Param("homework_title") String homework_title, @Param("teacher") Teacher teacher);

    @Select("SELECT CONTENT FROM SUBMIT WHERE HOMEWORK_TITLE=#{homework_title} and TEACHER_NAME=#{teacher.teacher_name} and STUDENT_NAME=#{student_name}")
    String CheckContent(@Param("homework_title") String homework_title, @Param("teacher") Teacher teacher, @Param("student_name") String student_name);
}
