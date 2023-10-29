package com.reinforcement.project;

import com.reinforcement.project.entities.concretes.Brand;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Nonnull;
import java.util.List;

@SpringBootTest
class ProjectApplicationTests {

	@Test
	void contextLoads() {
		foo();

		List<Brand> brands = Instancio.ofList(Brand.class).size(10).create();
		for (Brand brand : brands) {
			System.out.println("args = " + brand.getName() + " - " + brand.getId());
		}
	}

	static void foo() {
		log(null);
	}

	static void log(@Nonnull Object x) {
		System.out.println("x = " + x);
		if (x != null){
			System.out.println(x.toString());
		}
//		System.out.println("x hashCode = " + x.hashCode());
	}
}
