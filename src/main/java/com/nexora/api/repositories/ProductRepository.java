package com.nexora.api.repositories;

import com.nexora.api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
    List<Product> findByCategoryId(Long id);
    List<Product> findByPriceBetween(double minPrice, double maxPrice);
}
