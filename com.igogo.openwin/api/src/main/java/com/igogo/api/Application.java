package com.igogo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * Created by Lee on 2017/5/2.
 */
@SpringBootApplication
@ComponentScan("com.igogo.api.controller, com.igogo.service, com.igogo.core, com.igogo.entity")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
