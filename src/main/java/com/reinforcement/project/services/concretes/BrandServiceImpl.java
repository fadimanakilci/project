package com.reinforcement.project.services.concretes;

import com.reinforcement.project.dataAccess.abstracts.BrandRepository;
import com.reinforcement.project.entities.concretes.Brand;
import com.reinforcement.project.services.abstracts.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

// IoT
@Service
public class BrandServiceImpl implements BrandService {
    private BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
    @Override
    public List<Brand> getAll() {
        return brandRepository.getAll();
    }
}
