package com.example.test0821.service;

import com.example.test0821.entity.Student;

import java.util.List;

/**
 * @Description
 * @InterfaceName StudentService
 * @Author Xbao
 * @date 2020.08.22 12:23
 */
public interface StudentService {

    public void insertStudent(Student student);

    public void logoutStudentById(int id);

    public void updateStudent(Student student);

    public List<Student> selectStudentByName(String name);

    public Student selectStudentById(int id);

}
