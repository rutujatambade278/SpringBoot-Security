package com.implementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtRolebaseAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtRolebaseAuthenticationApplication.class, args);
		System.out.println("working.....");
	}

}
