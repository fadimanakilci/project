package com.reinforcement.project;

import com.reinforcement.project.entities.concretes.Brand;
import org.instancio.Instancio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Nonnull;
import java.util.List;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		foo();
		List<Brand> brands = Instancio.ofList(Brand.class).size(10).create();
		for (Brand brand : brands) {
			System.out.println("args = " + brand.getName() + " - " + brand.getId());
		}
		SpringApplication.run(ProjectApplication.class, args);
	}


	static void log(@Nonnull Object x) {
		System.out.println("x = " + x);
		if (x != null){
			System.out.println(x.toString());
		}
//		x.hashCode();
	}
	static void foo() {
		log(null);
	}

}
