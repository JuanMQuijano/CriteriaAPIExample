package com.jmquijano.criteria_practice.CriteriaPractice.controller;

import com.jmquijano.criteria_practice.CriteriaPractice.controller.dto.output.OrderDetailsDTO;
import com.jmquijano.criteria_practice.CriteriaPractice.controller.mapper.OrderMapper;
import com.jmquijano.criteria_practice.CriteriaPractice.usecase.order.GetOrders;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderMapper orderMapper;
    private final GetOrders getOrders;

    @GetMapping
    public ResponseEntity<List<OrderDetailsDTO>> getOrders(
            @RequestParam(required = false, name = "dateOne") String dateOne,
            @RequestParam(required = false, name = "dateTwo") String dateTwo
    ) {
        return ResponseEntity.ok(orderMapper.orderDetailsDTOList(getOrders.getOrders(dateOne, dateTwo)));
    }


}
