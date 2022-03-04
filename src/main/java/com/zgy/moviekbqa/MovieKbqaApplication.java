package com.zgy.moviekbqa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MovieKbqaApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MovieKbqaApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MovieKbqaApplication.class);
    }
}
