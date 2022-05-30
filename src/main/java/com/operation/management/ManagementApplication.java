package com.operation.management;

import javax.servlet.http.HttpSessionListener;

import com.operation.management.common.SessionListener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
@RestController
public class ManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementApplication.class, args);
	}

	@Bean

	public HttpSessionListener httpSessionListener(){
		return new SessionListener();
	}

	@GetMapping
    public String string(@Value("${greeting.message}") String message) {
        return message;
    }
	

}
