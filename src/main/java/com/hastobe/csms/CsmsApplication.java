package com.hastobe.csms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class CsmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsmsApplication.class, args);
    }

}
