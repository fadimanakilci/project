package com.reinforcement.project.services.abstracts;

import com.reinforcement.project.services.dtos.requests.CreateBrandRequest;
import com.reinforcement.project.services.dtos.requests.UpdateBrandRequest;
import com.reinforcement.project.services.dtos.responses.GetAllBrandsResponse;
import com.reinforcement.project.services.dtos.responses.GetByIdBrandResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(Long id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(Long id);
}
