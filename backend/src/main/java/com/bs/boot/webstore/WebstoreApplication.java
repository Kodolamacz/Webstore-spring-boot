package com.bs.boot.webstore;

import com.bs.boot.webstore.config.AuthorizationServerConfig;
import com.bs.boot.webstore.config.ResourceServerConfig;
import com.bs.boot.webstore.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

@SpringBootApplication
//@EnableAutoConfiguration
//@CrossOrigin(origins = "http://localhost:4200")
//@ComponentScan(basePackages = "com.bs.boot.webstore.*")
//@Controller
@Import({AuthorizationServerConfig.class, ResourceServerConfig.class, SecurityConfig.class})
public class WebstoreApplication extends SpringBootServletInitializer {



	public static void main(String[] args) {
		SpringApplication.run(WebstoreApplication.class, args);
	}


}
