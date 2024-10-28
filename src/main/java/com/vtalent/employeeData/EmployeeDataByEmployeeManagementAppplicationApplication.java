package com.vtalent.employeeData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EmployeeDataByEmployeeManagementAppplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDataByEmployeeManagementAppplicationApplication.class, args);
	}
	@Bean
	public RestTemplate get()
	{
		return new RestTemplate();
	}

}
