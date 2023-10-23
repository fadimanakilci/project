package com.reinforcement.project.dataAccess.abstracts;

import com.reinforcement.project.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
//@Component
//@AutoConfiguration
//@EnableJpaRepositories
//  @NoRepositoryBean annotation u olmadan BrandService ve BrandServiceImpl de hata veriyor!
//@NoRepositoryBean
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    //  Artık buna ihtiyacımız yok. Bu fonksiyonları JpaRepository den çekiyoruz.
      //  List<Brand> getAll();
}
