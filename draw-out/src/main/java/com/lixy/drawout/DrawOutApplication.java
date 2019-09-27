package com.lixy.drawout;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lixy.drawout.dao")
public class DrawOutApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrawOutApplication.class, args);
    }

}
