package com.dishe.vip.controller;

import com.dishe.vip.model.Product;
import com.dishe.vip.service.impl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Integer productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("/male")
    public List<Product> getAllMaleProducts() {
        return productService.findAllMaleProducts();
    }

    @GetMapping("/female")
    public List<Product> getAllFemaleProducts() {
        return productService.findAllFemaleProducts();
    }

    // Admin abilities
    @PostMapping
    public Product addNewProduct(@RequestBody Product newProduct) {
        return productService.addNewProduct(newProduct);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@RequestBody Product newProduct, @PathVariable Integer productId) {
        return productService.updateProduct(newProduct, productId);
    }
}
