package com.nexora.api.services;

import com.nexora.api.entities.ShoppingCartItem;
import com.nexora.api.repositories.ItemCartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCartService {

    private final ItemCartRepository itemCartRepository;

    public ItemCartService(ItemCartRepository itemCartRepository) {
        this.itemCartRepository = itemCartRepository;
    }

    public List<ShoppingCartItem> findAll(){
        return itemCartRepository.findAll();
    }

    public ShoppingCartItem save(ShoppingCartItem shoppingCartItem){
        return itemCartRepository.save(shoppingCartItem);
    }

    public void delete(Long id){
        itemCartRepository.deleteById(id);
    }
}
