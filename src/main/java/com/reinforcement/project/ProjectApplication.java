package com.reinforcement.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Nonnull;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		System.out.println("sdfghjklş");
		foo();
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
