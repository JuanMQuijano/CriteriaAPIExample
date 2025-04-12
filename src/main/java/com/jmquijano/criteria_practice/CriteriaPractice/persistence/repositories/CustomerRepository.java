package com.jmquijano.criteria_practice.CriteriaPractice.persistence.repositories;

import com.jmquijano.criteria_practice.CriteriaPractice.persistence.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CustomerRepository {

    private EntityManager entityManager;

    public List<Customer> getCustomers(Integer minOrders) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);

        Root<Customer> customerRoot = cq.from(Customer.class);
        Join<Customer, Order> customerOrderJoin = customerRoot.join("orders", JoinType.LEFT);

        cq.select(customerRoot).groupBy(customerRoot.get("id")).having(cb.gt(cb.count(customerOrderJoin), minOrders));

        return entityManager.createQuery(cq).getResultList();
    }


}
