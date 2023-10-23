package com.reinforcement.project;

import com.reinforcement.project.entities.concretes.Brand;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProjectApplicationTests {

	@Test
	void contextLoads() {
		List<Brand> brands = Instancio.ofList(Brand.class).size(10).create();
		for (Brand brand : brands) {
			System.out.println("args = " + brand.getName() + " - " + brand.getId());
		}
	}

}
