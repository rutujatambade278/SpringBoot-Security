package com.role.implementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoleBasedAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoleBasedAuthenticationApplication.class, args);
		System.out.println("working.....");
	}

}
