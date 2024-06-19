package com.inventory.omsaas.models.orders;

import com.inventory.omsaas.models.product.Product;
import com.inventory.omsaas.models.customers.Customer;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders") // Use 'orders' because 'order' is a reserved keyword in SQL
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    // Getters and Setters
}