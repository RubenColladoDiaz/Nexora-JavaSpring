package com.nexora.api.services;

import com.nexora.api.entities.Order;
import com.nexora.api.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Long id){
        return orderRepository.findById(id);
    }

    public Order save(Order product){
        return orderRepository.save(product);
    }

    public void delete(Long id){
        orderRepository.deleteById(id);
    }
}
