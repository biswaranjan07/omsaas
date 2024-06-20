package com.inventory.omsaas.models.customers;

import com.inventory.omsaas.models.orders.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false, unique = true)
    @Getter
    @Setter
    private String username;

    @Column(nullable = false)
    @Getter
    @Setter
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    @Getter
    @Setter
    private String email;

    @OneToMany(mappedBy = "customer")
    @Getter
    @Setter
    private Set<Order> orders;

}