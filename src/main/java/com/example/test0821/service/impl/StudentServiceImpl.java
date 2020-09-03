package com.example.test0821.service.impl;

import com.example.test0821.dao.StudentMapper;
import com.example.test0821.entity.Student;
import com.example.test0821.entity.StudentExample;
import com.example.test0821.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version: V1.0
 * @author: 陈小宝
 * @className: StudentServiceImpl
 * @packageName: com.example.test0821.service.impl
 * @description: 学生业务
 * @data: 2020-08-22 14:27
 */
@Service

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void insertStudent(Student student) {
        studentMapper.insertSelective(student);
    }

    @Override
    public void logoutStudentById(int id) {
        studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public List<Student> selectStudentByName(String name) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStudentNameLike("%"+name+"%");
        List<Student> student  = studentMapper.selectByExample(studentExample);
        return student;
    }

    @Override
    public Student selectStudentById(int id) {
        Student student = studentMapper.selectByPrimaryKey(id);
        return student;
    }
}
