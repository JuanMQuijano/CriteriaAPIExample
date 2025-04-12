package com.jmquijano.criteria_practice.CriteriaPractice.controller.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductDto(
        Long id,
        String name,
        Double price,
        @JsonProperty(value = "category_name")
        String categoryName
) {
}
