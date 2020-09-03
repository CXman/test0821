package com.example.test0821;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.example.test0821.dao")
public class Test0821Application {

    public static void main(String[] args) {
        SpringApplication.run(Test0821Application.class, args);
    }

}
