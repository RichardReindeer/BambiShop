package com.bambi.springday02jsp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bambi.springday02jsp.mapper")
public class SpringDay02JspApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDay02JspApplication.class, args);
    }

}
