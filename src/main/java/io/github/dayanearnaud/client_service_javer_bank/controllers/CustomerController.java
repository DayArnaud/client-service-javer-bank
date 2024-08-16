package io.github.dayanearnaud.client_service_javer_bank.controllers;

import io.github.dayanearnaud.client_service_javer_bank.clients.CustomerServiceClient;
import io.github.dayanearnaud.client_service_javer_bank.model.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerServiceClient customerServiceClient;

    @Autowired
    public CustomerController(CustomerServiceClient customerServiceClient) {
        this.customerServiceClient = customerServiceClient;
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody CustomerDTO customerDTO) {
        try {
            CustomerDTO createdCustomer = customerServiceClient.createCustomer(customerDTO);
            return ResponseEntity.ok(createdCustomer);
        } catch (ResponseStatusException e){
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        try {
            UUID uuid = UUID.fromString(id);
            CustomerDTO customer = customerServiceClient.getCustomerById(uuid);
            return ResponseEntity.ok(customer);
        } catch(ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        }

    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        try {
            List<CustomerDTO> customers = customerServiceClient.getAllCustomers();
            return ResponseEntity.ok(customers);
        } catch(ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody CustomerDTO customerDTO) {
        try {
            UUID uuid = UUID.fromString(id);
            CustomerDTO customer = customerServiceClient.updateCustomer(uuid, customerDTO);
            return ResponseEntity.ok(customer);
        } catch(ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        try {
            UUID uuid = UUID.fromString(id);
            customerServiceClient.deleteCustomer(uuid);
            return ResponseEntity.ok("Customer deleted successfully");
        } catch(ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        }

    }

    @GetMapping("/calculate-score/{id}")
    public ResponseEntity<?> calculateScore(@PathVariable String id) {
        try {
            UUID uuid = UUID.fromString(id);
            Double score = customerServiceClient.calculateCreditScore(uuid);
            return ResponseEntity.ok(score);
        } catch(ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        }
    }
}
