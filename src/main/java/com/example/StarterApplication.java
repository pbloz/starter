package com.example;

import javax.activation.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@RestController
//@EnableJpaRepositories
public class StarterApplication {
//    @RequestMapping("/")
//    String home() {
//        return "Hello World!";
//    }

	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
	}
	
}
