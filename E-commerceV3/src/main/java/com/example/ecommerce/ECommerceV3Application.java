package com.example.ecommerce;


import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.ecommerce.controller.AdminCategoriesController;
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.example.ecommerce","com.example.ecommerce.controller"})

@SpringBootApplication
public class ECommerceV3Application {


	
	public static void main(String[] args) {
		//	ConfigurableApplicationContext ctx=	
		new File(AdminCategoriesController.uploadDirectory).mkdir();
		ResourceConfig d= new ResourceConfig();

		SpringApplication.run(ECommerceV3Application.class, args);

	}

}

