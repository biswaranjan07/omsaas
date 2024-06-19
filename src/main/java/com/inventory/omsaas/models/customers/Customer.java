package com.inventory.omsaas.models.customers;

import com.inventory.omsaas.models.orders.Order;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

}