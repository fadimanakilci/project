package com.reinforcement.project;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.Nonnull;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages={"com.reinforcement.project"})
//@ComponentScan(basePackages = "com.reinforcement.project")
public class ProjectApplication {

	public static void main(String[] args) {
		foo();
		SpringApplication.run(ProjectApplication.class, args);
	}

	static void log(@Nonnull Object x) {
		System.out.println("x = " + x);
		if (x != null){
			System.out.println(x.toString());
		}
//		System.out.println("x hashCode = " + x.hashCode());
	}

	static void foo() {
		log(null);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

//	@Bean
//	public BrandRepository getBrandRepository() {
//		return new BrandRepository();
//	}
}
