package com.jmquijano.criteria_practice.CriteriaPractice.controller.mapper;

import com.jmquijano.criteria_practice.CriteriaPractice.controller.dto.output.ProductDto;
import com.jmquijano.criteria_practice.CriteriaPractice.persistence.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {

    public ProductDto toDto(Product entity) {
        return new ProductDto(entity.getId(), entity.getName(), entity.getPrice(), entity.getCategory().getName());
    }

    public List<ProductDto> toDtoList(List<Product> entities) {
        return entities.stream().map(this::toDto).toList();
    }

}
