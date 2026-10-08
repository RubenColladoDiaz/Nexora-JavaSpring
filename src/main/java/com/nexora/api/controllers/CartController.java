package com.nexora.api.controllers;

import com.nexora.api.entities.ShoppingCartItem;
import com.nexora.api.services.ItemCartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final ItemCartService itemCartService;

    public CartController(ItemCartService itemCartService) {
        this.itemCartService = itemCartService;
    }

    @GetMapping
    public List<ShoppingCartItem> showCart(){
        return itemCartService.findAll();
    }

    @PostMapping("/add")
    public ShoppingCartItem save(@RequestBody ShoppingCartItem shoppingCartItem){
        if (showCart().contains(shoppingCartItem))
            shoppingCartItem.setQuantity(shoppingCartItem.getQuantity() + 1);
        return itemCartService.save(shoppingCartItem);
    }

    @PutMapping("/{id}")
    public ShoppingCartItem update(@PathVariable Long id, @RequestBody ShoppingCartItem shoppingCartItem){
        shoppingCartItem.setId(id);
        return itemCartService.save(shoppingCartItem);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        itemCartService.delete(id);
    }
}
