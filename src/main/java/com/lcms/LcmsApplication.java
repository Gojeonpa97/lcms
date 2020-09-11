package com.lcms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.lcms.modules.**.**.dao")
public class LcmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LcmsApplication.class, args);
    }

}
