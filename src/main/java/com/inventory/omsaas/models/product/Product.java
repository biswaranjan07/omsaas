package com.inventory.omsaas.models.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    // TODO : Added setter for now. To have exclusive UUID gen
    private Long id;

    @Column(nullable = false, unique = true)
    @Getter
    @Setter
    private String name;

    @Column(nullable = false)
    @Getter
    @Setter
    private BigDecimal price;

    @Column(nullable = false, unique = true)
    @Getter
    @Setter
    private String sku;

}