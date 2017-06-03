package com.store.checkout.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.checkout.model.TaxCategory;

public interface TaxCategoryJpaRepository extends JpaRepository<TaxCategory, String> {
}