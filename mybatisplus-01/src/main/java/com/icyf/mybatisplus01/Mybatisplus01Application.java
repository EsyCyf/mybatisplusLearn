package com.icyf.mybatisplus01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@MapperScan("com.icyf.mybatisplus01.mapper")
//@ComponentScan("com.icyf.mybatisplus01")
public class Mybatisplus01Application {

    public static void main(String[] args) {
        SpringApplication.run(Mybatisplus01Application.class, args);
    }

}
