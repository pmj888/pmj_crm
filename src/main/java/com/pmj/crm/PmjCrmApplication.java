package com.pmj.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pmj.crm.mapper")
public class PmjCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmjCrmApplication.class, args);
    }

}
