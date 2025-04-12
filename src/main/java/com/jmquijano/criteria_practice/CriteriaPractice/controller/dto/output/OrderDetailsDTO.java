package com.jmquijano.criteria_practice.CriteriaPractice.controller.dto.output;

import java.time.LocalDate;
import java.util.List;

public record OrderDetailsDTO(
        Long id,
        String name,
        String email,
        LocalDate orderDate,
        List<ProductDto> products,
        Double totalPrice
) {
}
