package com.jmquijano.criteria_practice.CriteriaPractice.controller;

import com.jmquijano.criteria_practice.CriteriaPractice.controller.dto.output.CustomerDTO;
import com.jmquijano.criteria_practice.CriteriaPractice.controller.mapper.CustomerMapper;
import com.jmquijano.criteria_practice.CriteriaPractice.persistence.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getCustomers(@RequestParam Integer minOrders) {
        return ResponseEntity.ok(customerMapper.toDtoList(customerRepository.getCustomers(minOrders)));
    }

}
