package com.nestor.market.web.controller;

import com.nestor.market.domain.Product;
import com.nestor.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Controlador de una API REST
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/delete/{productId}")
    public boolean delete(@PathVariable("productId") int productId) {
        return productService.delete(productId);
    }

    @PutMapping("/update/{productId}")
    public Product update(@RequestBody Product product, @PathVariable("productId") int productId) {
        return productService.getProduct(productId)
                .map(product1 -> {
                    product1.setName(product.getName());
                    product1.setCategoryId(product.getCategoryId());
                    product1.setPrice(product.getPrice());
                    product1.setStock(product.getStock());
                    product1.setActive(product.isActive());
                    return productService.save(product1);
                }).orElseGet(() -> {
                    product.setProductId(productId);
                    return productService.save(product);
                });
    }

}
