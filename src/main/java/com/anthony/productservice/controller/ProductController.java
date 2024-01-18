package com.anthony.productservice.controller;

import com.anthony.productservice.model.Product;
import com.anthony.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping()
    public Product addProduct(@RequestBody Product product) {
//        System.out.println(product.toString());
//        System.out.println(product.description);
        return productRepository.save(product);
    }

    @GetMapping()
    public Iterable<Product> getProduct() {
        // Fetch from the DB and send
        System.out.println("Get mapping");
        return productRepository.findAll();
    }

    @PutMapping()
    public Product updateProduct(@RequestBody Product product) {
//        productRepository.updateProductById(product.getId());
        productRepository.save(product);
        return productRepository.findById(product.getId()).orElseThrow(() -> new RuntimeException("Could not update product"));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId){
        // Check if product exists
        if(productRepository.existsById(productId.intValue())){
            productRepository.deleteById(productId.intValue());
            return new ResponseEntity<>("Product successfully deleted", HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>("Product does not exist", HttpStatus.NOT_FOUND);
        }
    }
}
