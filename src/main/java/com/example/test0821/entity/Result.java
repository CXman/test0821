package com.example.test0821.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;

/**
 * @version: V1.0
 * @author: 陈小宝
 * @className: Result
 * @packageName: com.example.test0821.entity
 * @description: 返回结果
 * @data: 2020-08-22 14:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private boolean success;
    private String code;
    private String message;
    private Object object;
    public Result(boolean success){
        this.success = success;
    }
}
