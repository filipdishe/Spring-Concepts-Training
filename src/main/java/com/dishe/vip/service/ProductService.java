package com.dishe.vip.service;

import com.dishe.vip.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product getProductById(Integer productId);

    List<Product> findAllMaleProducts();

    List<Product> findAllFemaleProducts();

    // Admin abilities
    Product addNewProduct(Product product);

    void deleteProduct(Integer productId);

    Product updateProduct(Product newProduct, Integer productId);
}
