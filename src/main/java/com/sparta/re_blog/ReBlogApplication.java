package com.sparta.re_blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication

public class ReBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReBlogApplication.class, args);
    }

}
