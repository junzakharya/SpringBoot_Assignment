package com.example.GreenStitch_Assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GreenStitchAssignmentApplication {

	public static void main(String[] args) {

		SpringApplication.run(GreenStitchAssignmentApplication.class, args);
	}

}
