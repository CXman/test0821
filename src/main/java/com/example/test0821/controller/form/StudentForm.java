package com.example.test0821.controller.form;

import com.example.test0821.util.TimeUtil;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @version: V1.0
 * @author: 陈小宝
 * @className: StudentForm
 * @packageName: com.example.test0821.controller.form
 * @description: 注册学生等操作时添加的对象
 * @data: 2020-08-22 14:18
 */
@Data
public class StudentForm  {


    private Integer studentId;

    @NotNull
    @NotBlank
    @Length(max=50)
    private String studentName;

    @NotNull
    @NotBlank
    @Length(min=10,max = 10)
    private String studentBirth;

    @NotNull
    @Max(3)
    @Min(0)
    private Integer studentStatus;

    @NotNull
    @NotBlank
    @Length(min=10,max = 10)
    private String studentRegistTime;

    @NotNull
    @NotEmpty
    private String studentSchool;

    @NotNull
    @NotBlank
    private String studentMajor;

    @NotNull
    @NotEmpty
    @Length(min=10,max = 10)
    private String studentGraduateTime;
}
