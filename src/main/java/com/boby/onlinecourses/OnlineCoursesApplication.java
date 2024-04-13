package com.boby.onlinecourses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class OnlineCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCoursesApplication.class, args);
	}

}
