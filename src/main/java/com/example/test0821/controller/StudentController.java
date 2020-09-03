package com.example.test0821.controller;

import com.example.test0821.controller.form.StudentForm;
import com.example.test0821.entity.Result;
import com.example.test0821.entity.Student;
import com.example.test0821.service.StudentService;
import com.example.test0821.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @version: V1.0
 * @author: 陈小宝
 * @className: StudentController
 * @packageName: com.example.test0821.controller
 * @description: 商品
 * @data: 2020-08-21 16:16
 */
@RestController
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("insert")
    public Result insertStudent(@Valid StudentForm studentForm, BindingResult bindingResult) throws ParseException {
        if(bindingResult.hasErrors()){
            List<ObjectError> errors = bindingResult.getAllErrors();
            System.out.println("参数校验错误");
            for(ObjectError objectError:errors){
                System.out.println("参数名称："+objectError.getObjectName());
                System.out.println("错误类型："+objectError.getDefaultMessage());
            }
            return new Result(false,"0001","参数校验错误",null);
        }
        Student student = new Student();
        student.setStudentName(studentForm.getStudentName());
        student.setStudentBirth(studentForm.getStudentBirth());
        student.setStudentStatus(studentForm.getStudentStatus());
        student.setStudentRegistTime(TimeUtil.getDateTime(studentForm.getStudentRegistTime()));
        student.setStudentSchool(studentForm.getStudentSchool());
        student.setStudentMajor(studentForm.getStudentMajor());
        student.setStudentGraduateTime(TimeUtil.getDateTime(studentForm.getStudentGraduateTime()));
        System.out.println(student.toString());
        studentService.insertStudent(student);
        return new Result(true,"1000","新增学生",null);
    }

    @DeleteMapping("logout/{studentId}")
    public Result logoutStudent(@PathVariable("studentId") Integer id)throws Exception{
        Student student = studentService.selectStudentById(id);
        if(null==student){
            Result result = new Result();
            result.setSuccess(false);
            result.setMessage("查询不到该id的学生");
            return result;
        }
        int status = student.getStudentStatus();
        if(status==3||status==4){
            Result result = new Result();
            result.setSuccess(false);
            result.setMessage("该学生不满足退学条件");
            return result;
        }
        studentService.logoutStudentById(id);
        return new Result(true);
    }

    @PutMapping("update")
    public Result updateStudent(@Valid @Param("student")StudentForm studentForm, BindingResult bindingResult) throws ParseException {
        if(bindingResult.hasErrors()){
            List<ObjectError> errors = bindingResult.getAllErrors();
            System.out.println("参数校验错误");
            for(ObjectError objectError:errors){
                System.out.println("参数名称："+objectError.getObjectName());
                System.out.println("错误类型："+objectError.getDefaultMessage());
            }
            return new Result(false);
        }
        Student student = new Student();
        student.setStudentId(studentForm.getStudentId());
        student.setStudentName(studentForm.getStudentName());
        student.setStudentBirth(studentForm.getStudentBirth());
        student.setStudentStatus(studentForm.getStudentStatus());
        student.setStudentRegistTime(TimeUtil.getDateTime(studentForm.getStudentRegistTime()));
        student.setStudentSchool(studentForm.getStudentSchool());
        student.setStudentMajor(studentForm.getStudentMajor());
        student.setStudentGraduateTime(TimeUtil.getDateTime(studentForm.getStudentGraduateTime()));
        System.out.println(student.toString());
        studentService.updateStudent(student);
        return new Result(true);
    }

    @GetMapping("selectByName/{studentName}")
    public Result selectStudentLikeName(@PathVariable("studentName") String name)throws Exception{
        List<Student> list = studentService.selectStudentByName(name);
        Result result = new Result();
        result.setObject(list);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("selectById/{studentId}")
    public Result selectStudentById(@PathVariable("studentId") int id)throws Exception{
        Student student = studentService.selectStudentById(id);
        Result result = new Result();
        result.setObject(student);
        result.setSuccess(true);
        return result;
    }
}
