package com.boby.onlinecourses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
//@EntityScan(basePackages = {"**entities_package_name"})
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class OnlineCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCoursesApplication.class, args);
	}

}
