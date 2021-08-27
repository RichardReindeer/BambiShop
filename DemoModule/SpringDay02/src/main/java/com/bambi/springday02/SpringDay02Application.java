package com.bambi.springday02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bambi.springday02.mapper")
public class SpringDay02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringDay02Application.class, args);
    }

}
