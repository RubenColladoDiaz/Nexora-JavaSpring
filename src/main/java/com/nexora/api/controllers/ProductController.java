package com.nexora.api.controllers;

import com.nexora.api.entities.Product;
import com.nexora.api.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<Product> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort
    ) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

        return productService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("/search{name}")
    public Optional<Product> findByName(@PathVariable String name){
        return productService.findByName(name);
    }

    @GetMapping("/category/{id}")
    public List<Product> findByCategoryId(@PathVariable Long id){
        return productService.findByCategoryId(id);
    }

    @GetMapping("/{minPrice}{maxPrice}")
    public List<Product> findByPriceBetween(double minPrice, double maxPrice){
        return productService.findByPriceBetween(minPrice, maxPrice);
    }
}