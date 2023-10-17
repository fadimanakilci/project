package com.reinforcement.project.dataAccess.abstracts;

import com.reinforcement.project.entities.concretes.Brand;

import java.util.List;

public interface BrandRepository {
    List<Brand> getAll();
}
