package com.jmquijano.criteria_practice.CriteriaPractice.controller;

import com.jmquijano.criteria_practice.CriteriaPractice.controller.dto.output.ProductDto;
import com.jmquijano.criteria_practice.CriteriaPractice.controller.mapper.ProductMapper;
import com.jmquijano.criteria_practice.CriteriaPractice.usecase.product.GetProducts;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private GetProducts getProducts;
    private ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts(
            @RequestParam(required = false, name = "categoryId") Long categoryId,
            @RequestParam(required = false, name = "maxPrice") Double maxPrice
    ) {
        return ResponseEntity.ok(productMapper.toDtoList(getProducts.getProducts(categoryId, maxPrice)));
    }


}
