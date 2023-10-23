package com.reinforcement.project.api.web.controllers;

import com.reinforcement.project.services.abstracts.BrandService;
import com.reinforcement.project.services.requests.CreateBrandRequest;
import com.reinforcement.project.services.responses.GetAllBrandsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// Bu yokken çalışmıyor, bean oluşturma hatası veriyordu
@EnableJpaRepositories
//@EnableAutoConfiguration
//@Controller
@RequestMapping("/api/brands")
public class BrandsController {
    private BrandService brandService;

    // Springin yeni versiyonlarında yazmasak da Autowired olarak çalışıyor
    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getall")
    public List<GetAllBrandsResponse> getAll() {
        return  brandService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody() CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }
}
