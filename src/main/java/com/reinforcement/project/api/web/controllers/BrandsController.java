package com.reinforcement.project.api.web.controllers;

import com.reinforcement.project.services.abstracts.BrandService;
import com.reinforcement.project.services.dtos.requests.CreateBrandRequest;
import com.reinforcement.project.services.dtos.requests.UpdateBrandRequest;
import com.reinforcement.project.services.dtos.responses.GetAllBrandsResponse;
import com.reinforcement.project.services.dtos.responses.GetByIdBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// Bu yokken çalışmıyor, bean oluşturma hatası veriyordu
@EnableJpaRepositories
//@EnableAutoConfiguration
@Controller
@AllArgsConstructor
@RequestMapping("/api/brands")
public class BrandsController {
    @Autowired
    private BrandService brandService;

    // Springin yeni versiyonlarında yazmasak da Autowired olarak çalışıyor
    //  @AllArgsConstructor kullandık ve buna gerek kalmadı
    //  @Autowired
    //  public BrandsController(BrandService brandService) {
    //      this.brandService = brandService;
    //  }

//    @GetMapping("/getall")
    @GetMapping()
    public List<GetAllBrandsResponse> getAll() {
        return  this.brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable Long id) {
        return brandService.getById(id);
    }

//    @PostMapping("/add")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.brandService.delete(id);
    }


}
