package com.jmquijano.criteria_practice.CriteriaPractice.usecase.product;

import com.jmquijano.criteria_practice.CriteriaPractice.persistence.entities.Product;
import com.jmquijano.criteria_practice.CriteriaPractice.persistence.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetProducts {

    private ProductRepository productRepository;

    public List<Product> getProducts(Long categoryId, Double maxPrice) {
        return productRepository.getProducts(categoryId, maxPrice);
    }

}
