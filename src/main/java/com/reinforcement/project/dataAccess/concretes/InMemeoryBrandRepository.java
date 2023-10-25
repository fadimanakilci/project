package com.reinforcement.project.dataAccess.concretes;

// JPA dan sonra silebiriz. Gerek kalmadı.
// Concretes a gerek yok. Çünkü JPA kendisi generic çalışır, bellekte implement etmiş gibi yer ayırır.

//public class InMemeoryBrandRepository implements BrandRepository {
//    List<Brand> brands;
//
//    @Autowired
//    public InMemeoryBrandRepository() {
//        brands = new ArrayList<Brand>();
//        brands.add(new Brand(1, "BMV"));
//        brands.add(new Brand(2, "Audi"));
//        brands.add(new Brand(3, "Honda"));
//        brands.add(new Brand(4, "Mercedes"));
//        brands.add(new Brand(5, "Jeep"));
//    }
//
////    @Override
//    public List<Brand> getAll() {
//        return brands;
//    }
//}
