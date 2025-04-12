package com.jmquijano.criteria_practice.CriteriaPractice.controller.mapper;

import com.jmquijano.criteria_practice.CriteriaPractice.controller.dto.output.OrderDetailsDTO;
import com.jmquijano.criteria_practice.CriteriaPractice.controller.dto.output.ProductDto;
import com.jmquijano.criteria_practice.CriteriaPractice.persistence.entities.Order;
import com.jmquijano.criteria_practice.CriteriaPractice.persistence.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {

    public OrderDetailsDTO toOrderDetailsDTO(Order order) {
        return new OrderDetailsDTO(
                order.getId(),
                order.getCustomer().getName(),
                order.getCustomer().getEmail(),
                order.getOrderDate(),
                products(order.getProducts()),
                order.getTotalPrice());
    }

    public List<OrderDetailsDTO> orderDetailsDTOList(List<Order> orders) {
        return orders.stream().map(this::toOrderDetailsDTO).toList();
    }

    public List<ProductDto> products(List<Product> products) {
        return products.stream().map(p -> new ProductDto(p.getId(), p.getName(), p.getPrice(), p.getCategory().getName())).toList();
    }

}
