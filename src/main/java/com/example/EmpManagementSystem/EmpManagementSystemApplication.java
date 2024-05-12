package com.example.EmpManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class EmpManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpManagementSystemApplication.class, args);
	}

}
