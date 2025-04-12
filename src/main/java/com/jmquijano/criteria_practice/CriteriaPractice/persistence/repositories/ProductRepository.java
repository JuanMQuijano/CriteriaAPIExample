package com.jmquijano.criteria_practice.CriteriaPractice.persistence.repositories;

import com.jmquijano.criteria_practice.CriteriaPractice.persistence.entities.Category;
import com.jmquijano.criteria_practice.CriteriaPractice.persistence.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class ProductRepository {

    private EntityManager entityManager;

    public List<Product> getProducts(Long categoryId, Double maxPrice) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);

        Root<Product> productRoot = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        Category category = null;
        if (categoryId != null && categoryId > 0) {
            category = entityManager.find(Category.class, categoryId);
            if (category != null) {
                predicates.add(cb.equal(productRoot.get("category"), category));
            }
        }

        if (maxPrice != null && maxPrice > 0) {
            predicates.add(cb.lessThanOrEqualTo(productRoot.get("price"), maxPrice));
        }

        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(new Predicate[0])));
        }

        return entityManager.createQuery(cq).getResultList();
    }


}
