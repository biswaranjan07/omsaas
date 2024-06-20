package com.inventory.omsaas.repository;


import com.inventory.omsaas.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}