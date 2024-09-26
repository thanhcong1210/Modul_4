package com.example.blog_update;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlogUpdateApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogUpdateApplication.class, args);
    }

}
