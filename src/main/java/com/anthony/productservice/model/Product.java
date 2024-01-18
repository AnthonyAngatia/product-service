package com.anthony.productservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    String name;
    String description;
    BigDecimal price;
    Integer quantity;
    @JsonIgnore
    private Boolean isAvailable;

}
