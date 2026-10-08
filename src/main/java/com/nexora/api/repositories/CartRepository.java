package com.nexora.api.repositories;

import com.nexora.api.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<ShoppingCart, Long> {
}
