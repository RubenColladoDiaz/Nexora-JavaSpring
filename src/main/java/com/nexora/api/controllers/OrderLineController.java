package com.nexora.api.controllers;

import com.nexora.api.entities.OrderLine;
import com.nexora.api.services.OrderLineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order-lines")
public class OrderLineController {

    private final OrderLineService orderLineService;

    public OrderLineController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

    @GetMapping
    public List<OrderLine> findAll() {
        return orderLineService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<OrderLine> findById(@PathVariable Long id) {
        return orderLineService.findById(id);
    }

    @PostMapping
    public OrderLine save(@RequestBody OrderLine orderLine) {
        return orderLineService.save(orderLine);
    }

    @PutMapping("/{id}")
    public OrderLine update(@PathVariable Long id, @RequestBody OrderLine orderLine) {
        orderLine.setId(id);
        return orderLineService.save(orderLine);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderLineService.delete(id);
    }
}
