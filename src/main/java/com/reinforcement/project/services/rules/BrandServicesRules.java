package com.reinforcement.project.services.rules;

import com.reinforcement.project.core.utilities.exceptions.BusinessException;
import com.reinforcement.project.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BrandServicesRules {
    private BrandRepository brandRepository;

    public void checkIfBrandNameExists(String name){
        if(this.brandRepository.existsByName(name)) {
            throw new BusinessException("Brand name already exists");
        }
    }
}
