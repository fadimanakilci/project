package com.reinforcement.project.dataAccess.abstracts;

import com.reinforcement.project.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

//@Repository
@Service
//@NoRepositoryBean
public interface BrandRepository extends JpaRepository<Brand, Long> {
    //  Artık buna ihtiyacımız yok. Bu fonksiyonları JpaRepository den çekiyoruz.
//        List<Brand> getAll();

    //  Spring JPA Keywords
    //  exists key => veritabanında sorgu oluşturup boolean bir değer döndüren key
    //  find key => veritabanında arama yapıp verilen değeri getirir
    boolean existsByName(String name);
}
