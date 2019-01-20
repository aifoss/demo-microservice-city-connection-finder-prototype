package com.demo.microservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main application for prototype version of demo microservice for checking connections between cities.  
 * 
 * @author sofia
 * @date 2019-01-19
 */
@SpringBootApplication
@ComponentScan("com.demo.microservice")
@EnableSwagger2
public class CityConnectionFinderPrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityConnectionFinderPrototypeApplication.class, args);
	}

}
