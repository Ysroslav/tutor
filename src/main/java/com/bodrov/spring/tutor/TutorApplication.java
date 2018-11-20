package com.bodrov.spring.tutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.bodrov.spring.tutor.database")
@SpringBootApplication
public class TutorApplication {

	public static void main(String[] args) {
		System.getProperty("java.classpath");
		SpringApplication.run(TutorApplication.class, args);
	}
}
