package com.jmquijano.criteria_practice.CriteriaPractice.controller.mapper;

import com.jmquijano.criteria_practice.CriteriaPractice.controller.dto.output.CustomerDTO;
import com.jmquijano.criteria_practice.CriteriaPractice.controller.dto.output.CustomerTotalDTO;
import com.jmquijano.criteria_practice.CriteriaPractice.persistence.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerMapper {

    public CustomerDTO toDto(Customer entity) {
        return new CustomerDTO(entity.getId(), entity.getName(), entity.getEmail());
    }

    public List<CustomerDTO> toDtoList(List<Customer> entities) {
        return entities.stream().map(this::toDto).toList();
    }

    public CustomerTotalDTO toDtoTotal(Customer entity) {
        return new CustomerTotalDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.);
    }

    public List<CustomerTotalDTO> toDtoTotalList(List<Customer> entities) {
        return entities.stream().map(this::toDtoTotal).toList();
    }


}
