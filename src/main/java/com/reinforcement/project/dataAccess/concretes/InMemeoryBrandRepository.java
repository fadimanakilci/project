package com.reinforcement.project.dataAccess.concretes;

import com.reinforcement.project.dataAccess.abstracts.BrandRepository;
import com.reinforcement.project.entities.concretes.Brand;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemeoryBrandRepository implements BrandRepository {
    List<Brand> brands;

    public InMemeoryBrandRepository() {
        brands = new ArrayList<Brand>();
        brands.add(new Brand(1, "BMV"));
        brands.add(new Brand(2, "Audi"));
        brands.add(new Brand(3, "Honda"));
        brands.add(new Brand(4, "Mercedes"));
        brands.add(new Brand(5, "Jeep"));
    }

    @Override
    public List<Brand> getAll() {
        return brands;
    }
}
