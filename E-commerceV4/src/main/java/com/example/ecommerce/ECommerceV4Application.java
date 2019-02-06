package com.example.ecommerce;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.example.ecommerce.controller.AdminCategoriesController;
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.example.ecommerce","com.example.ecommerce.controller"})

@SpringBootApplication
public class ECommerceV4Application {

	public static void main(String[] args) {

		//	ConfigurableApplicationContext ctx=	
		new File(AdminCategoriesController.uploadDirectory).mkdir();
		ResourceConfig d= new ResourceConfig();


		SpringApplication.run(ECommerceV4Application.class, args);
	}
	
	public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver, SpringSecurityDialect sec) {
	    final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);
	    templateEngine.addDialect(sec); // Enable use of "sec"
	    return templateEngine;
	}
}

