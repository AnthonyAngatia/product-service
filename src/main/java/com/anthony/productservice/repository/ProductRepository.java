package com.anthony.productservice.repository;

import com.anthony.productservice.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product save(Product product);

    Iterable<Product> findAll();

    Optional<Product> findById(Long id);

    //    void updateProductById(Long id);


}
