package api.ecommerce.br.apiecommerce.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.ecommerce.br.apiecommerce.model.Brand;
import api.ecommerce.br.apiecommerce.repository.BrandRepository;


@Service

public class BrandService {
    
    @Autowired
    private BrandRepository brandRepository;

    public List<String> getNameCategoryByBrand(String category){
        List<Brand> brandByCigarrets = brandRepository.findByCategory("cigarrets");
        List<Brand> brandByBeers = brandRepository.findByCategory("beers");
        
        if(category.equalsIgnoreCase("cigarrets")){

           return brandByCigarrets.stream()
                .map(Brand::getName)
                .collect(Collectors.toList());
        }

        if(category.equalsIgnoreCase("beers")){
            
            return brandByBeers.stream()
                .map(Brand::getName)
                .collect(Collectors.toList());
        
        }

        return null;

    }
}

