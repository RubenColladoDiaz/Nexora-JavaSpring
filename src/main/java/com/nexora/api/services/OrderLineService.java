package com.nexora.api.services;

import com.nexora.api.entities.OrderLine;
import com.nexora.api.repositories.OrderLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;

    public OrderLineService(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    public List<OrderLine> findAll(){
        return orderLineRepository.findAll();
    }

    public Optional<OrderLine> findById(Long id){
        return orderLineRepository.findById(id);
    }

    public OrderLine save(OrderLine product){
        return orderLineRepository.save(product);
    }

    public void delete(Long id){
        orderLineRepository.deleteById(id);
    }
}
