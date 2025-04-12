package com.jmquijano.criteria_practice.CriteriaPractice.usecase.order;

import com.jmquijano.criteria_practice.CriteriaPractice.persistence.entities.Order;
import com.jmquijano.criteria_practice.CriteriaPractice.persistence.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetOrders {

    private OrderRepository orderRepository;

    public List<Order> getOrders(String dateOne, String dateTwo) {
        return orderRepository.getOrders(dateOne, dateTwo);
    }

}
