package com.cg.capstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan("com.cg.capstore")
public class CapstoreApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(CapstoreApplication.class, args);
	}

}
