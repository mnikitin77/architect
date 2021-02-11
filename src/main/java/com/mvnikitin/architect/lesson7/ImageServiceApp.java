package com.mvnikitin.architect.lesson7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ImageServiceApp {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ImageServiceApp.class, args);
    }
}
