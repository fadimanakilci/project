package com.reinforcement.project.services.concretes;

import com.reinforcement.project.dataAccess.abstracts.BrandRepository;
import com.reinforcement.project.entities.concretes.Brand;
import com.reinforcement.project.services.abstracts.BrandService;
import com.reinforcement.project.services.requests.CreateBrandRequest;
import com.reinforcement.project.services.responses.GetAllBrandsResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// IoT
// Manager -> ServiceImpl
@Service
//@Component
//@EnableJpaRepositories
//@NoAutoStart
public class BrandServiceImpl implements BrandService {
    private BrandRepository brandRepository;

//    @Autowired
//    public BrandServiceImpl(BrandRepository brandRepository) {
//        this.brandRepository = brandRepository;
//    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponses = new ArrayList<GetAllBrandsResponse>();

        for (Brand brand : brands) {
            GetAllBrandsResponse response = new GetAllBrandsResponse();
            response.setId(brand.getId());
            response.setName(brand.getName());
            brandsResponses.add(response);
        }
        return brandsResponses;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());
        this.brandRepository.save(brand);
    }
}
