package com.nabin.SpringBootEmployeeCRUDProgram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootEmployeeCrudProgramApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeCrudProgramApplication.class, args);
	}

}
