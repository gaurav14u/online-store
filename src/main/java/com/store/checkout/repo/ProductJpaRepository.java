package com.store.checkout.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.checkout.model.Product;

public interface ProductJpaRepository extends JpaRepository<Product, String> {
}