package com.nexora.api.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "shoppingCart")
    private List<ShoppingCartItem> shoppingCartItems = new ArrayList<>();

    @OneToOne(mappedBy = "shoppingCart")
    private User user;

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                '}';
    }
}