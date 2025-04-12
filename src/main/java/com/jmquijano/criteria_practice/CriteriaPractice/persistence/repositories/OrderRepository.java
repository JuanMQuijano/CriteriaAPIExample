package com.jmquijano.criteria_practice.CriteriaPractice.persistence.repositories;

import com.jmquijano.criteria_practice.CriteriaPractice.persistence.entities.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Repository
public class OrderRepository {

    private final EntityManager em;

    public List<Order> getOrders(String dateOne, String dateTwo) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);

        Root<Order> orderRoot = cq.from(Order.class);
        orderRoot.join("customer", JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(dateOne)) {
            LocalDate dateStart = LocalDate.parse(dateOne);
            predicates.add(cb.greaterThanOrEqualTo(orderRoot.get("orderDate"), dateStart));
        }

        if (StringUtils.hasText(dateTwo)) {
            LocalDate dateEnd = LocalDate.parse(dateTwo);
            predicates.add(cb.lessThanOrEqualTo(orderRoot.get("orderDate"), dateEnd));
        }

        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(new Predicate[0])));
        }

        return em.createQuery(cq).getResultList();
    }


}
