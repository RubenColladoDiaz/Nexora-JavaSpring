package com.nexora.api.repositories;

import com.nexora.api.entities.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemCartRepository extends JpaRepository<ShoppingCartItem, Long> {
}
