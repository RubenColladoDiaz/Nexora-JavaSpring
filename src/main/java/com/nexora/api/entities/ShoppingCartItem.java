package com.nexora.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShoppingCartItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    @Column(nullable = false)
    @NotBlank(message = "Quantity is required")
    private int quantity = 0;

    @ManyToOne
    @JoinColumn(name = "shoppingCart_id")
    private ShoppingCart shoppingCart;

    @Override
    public String toString() {
        return "ShoppingCartItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
