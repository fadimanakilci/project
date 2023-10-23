package com.reinforcement.project.services.abstracts;

import com.reinforcement.project.services.requests.CreateBrandRequest;
import com.reinforcement.project.services.responses.GetAllBrandsResponse;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    void add(CreateBrandRequest createBrandRequest);
}
