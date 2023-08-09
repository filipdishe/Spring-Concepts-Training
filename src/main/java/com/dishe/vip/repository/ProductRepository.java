package com.dishe.vip.repository;

import com.dishe.vip.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.productType.sexType = 'male'")
    List<Product> findAllByProductTypeMale();

    @Query("SELECT p FROM Product p WHERE p.productType.sexType = 'female'")
    List<Product> findAllByProductTypeFemale();
}
