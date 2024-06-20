package com.inventory.omsaas.controllers;

import com.inventory.omsaas.models.customers.Customer;
import com.inventory.omsaas.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // GET all customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return ResponseEntity.ok(customers);
    }

    // GET customer by ID
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        return customerOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // POST create a new customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    // PUT update an existing customer
    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer updatedCustomer) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            updatedCustomer.setId(customerId);
            Customer savedCustomer = customerRepository.save(updatedCustomer);
            return ResponseEntity.ok(savedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE delete a customer
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        customerRepository.deleteById(customerId);
        return ResponseEntity.noContent().build();
    }
}