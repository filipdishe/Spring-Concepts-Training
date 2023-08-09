package com.dishe.vip.service.impl;

import com.dishe.vip.exception.ProductNotFoundException;
import com.dishe.vip.model.Product;
import com.dishe.vip.repository.ProductRepository;
import com.dishe.vip.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));
    }

    @Override
    public List<Product> findAllMaleProducts() {
        return productRepository.findAllByProductTypeMale();
    }

    @Override
    public List<Product> findAllFemaleProducts() {
        return productRepository.findAllByProductTypeFemale();
    }

    @Override
    public Product addNewProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product updateProduct(Product newProduct, Integer productId) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id " + productId + ", you cannot update a product that don't exist!"));

        existingProduct.setProductName(newProduct.getProductName());
        existingProduct.setDescription(newProduct.getDescription());
        existingProduct.setPrice(newProduct.getPrice());
        existingProduct.setQuantity(newProduct.getQuantity());
        existingProduct.setProductType(newProduct.getProductType());
        existingProduct.setProductImages(newProduct.getProductImages());

        return productRepository.save(existingProduct);
    }
}
