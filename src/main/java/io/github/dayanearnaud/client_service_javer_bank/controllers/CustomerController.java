package io.github.dayanearnaud.client_service_javer_bank.controllers;

import io.github.dayanearnaud.client_service_javer_bank.clients.CustomerServiceClient;
import io.github.dayanearnaud.client_service_javer_bank.model.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/customers")
    public ResponseEntity<?> create(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO createdCustomer = customerServiceClient.createCustomer(customerDTO);
        return ResponseEntity.ok(createdCustomer);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        CustomerDTO customer = customerServiceClient.getCustomerById(uuid);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/customers")
    public ResponseEntity<?> findAll() {
        List<CustomerDTO> customers = customerServiceClient.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody CustomerDTO customerDTO) {
            UUID uuid = UUID.fromString(id);
            customerServiceClient.updateCustomer(uuid, customerDTO);
            return ResponseEntity.ok("Customer updated successfully.");
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
            UUID uuid = UUID.fromString(id);
            customerServiceClient.deleteCustomer(uuid);
            return ResponseEntity.ok("Customer deleted successfully");
    }

    @GetMapping("/customers/calculate-score/{id}")
    public ResponseEntity<?> calculateScore(@PathVariable String id) {
            UUID uuid = UUID.fromString(id);
            Double score = customerServiceClient.calculateCreditScore(uuid);
            return ResponseEntity.ok(score);
    }
}
