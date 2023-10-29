package com.reinforcement.project.services.concretes;

import com.reinforcement.project.core.utilities.mappers.ModelMapperService;
import com.reinforcement.project.dataAccess.abstracts.BrandRepository;
import com.reinforcement.project.entities.concretes.Brand;
import com.reinforcement.project.services.abstracts.BrandService;
import com.reinforcement.project.services.dtos.requests.CreateBrandRequest;
import com.reinforcement.project.services.dtos.requests.UpdateBrandRequest;
import com.reinforcement.project.services.dtos.responses.GetAllBrandsResponse;
import com.reinforcement.project.services.dtos.responses.GetByIdBrandResponse;
import com.reinforcement.project.services.rules.BrandServicesRules;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// IoT
// Manager -> ServiceImpl
@Service
@AllArgsConstructor
//@Controller
//@Component
@NoArgsConstructor
public class BrandServiceImpl implements BrandService {
//    @Autowired
//    @MockBean(classes = BrandRepository.class)
//    @Nonnull
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandServicesRules brandServicesRules;

//    @AllArgsConstructor bu fonksiyonu varmış gibi çalıştırıyor
//    public BrandServiceImpl(BrandRepository brandRepository) {
//        this.brandRepository = brandRepository;
//    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
//        List<GetAllBrandsResponse> brandsResponses = new ArrayList<GetAllBrandsResponse>();
//        for (Brand brand : brands) {
//            GetAllBrandsResponse response = new GetAllBrandsResponse();
//            response.setId(brand.getId());
//            response.setName(brand.getName());
//            brandsResponses.add(response);
//        }
        List<GetAllBrandsResponse> brandsResponses = brands.stream()
                .map(brand -> this.modelMapperService.forResponse().map(brand,GetAllBrandsResponse.class))
                .collect(Collectors.toList());
        return brandsResponses;
    }

    @Override
    public GetByIdBrandResponse getById(Long id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandServicesRules.checkIfBrandNameExists(createBrandRequest.getName());
//        Brand brand = new Brand();
//        brand.setName(createBrandRequest.getName());
        System.out.println("createBrandRequest = " + createBrandRequest.getName());
//        @Nonnull
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        System.out.println("brand = " + brand.getName());
//        BrandRepository brandRepository1 = new BrandRepository() {};
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(Long id) {
        this.brandRepository.deleteById(id);
    }
}
