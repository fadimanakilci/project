package com.reinforcement.project.api.web.controllers;

import com.reinforcement.project.entities.concretes.Brand;
import com.reinforcement.project.services.abstracts.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    private BrandService brandService;

    // Springin yeni versiyonlarında yazmasak da Autowired olarak çalışıyor
    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getall")
    public List<Brand> getAll() {
        return  brandService.getAll();
    }
}
