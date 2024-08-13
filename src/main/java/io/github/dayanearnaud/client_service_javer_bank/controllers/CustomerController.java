package io.github.dayanearnaud.client_service_javer_bank.controllers;

import io.github.dayanearnaud.client_service_javer_bank.model.CustomerDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://api-da-app2";

    @Autowired
    public CustomerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody CustomerDTO customerDTO) {
        try {
            String url = baseUrl + "/customers/";
            ResponseEntity<?> response = restTemplate.postForEntity(url, customerDTO, CustomerController.class);
            return ResponseEntity.ok(response.getBody());
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        try {
            UUID uuid = UUID.fromString(id);
            String url = baseUrl + "/customers/" + uuid.toString();
            ResponseEntity<CustomerDTO> response = restTemplate.getForEntity(url, CustomerDTO.class);
            return ResponseEntity.ok(response.getBody());
        } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body("Invalid UUID format:" + e.getMessage());
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        String url = baseUrl + "/customers/";
        ResponseEntity<?> response = restTemplate.getForEntity(url, CustomerDTO[].class);
        return ResponseEntity.ok(response.getBody());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody CustomerDTO customerDTO) {
        try{
            UUID uuid = UUID.fromString(id);
            String url = baseUrl + "/customers/" + uuid.toString();
            restTemplate.put(url, customerDTO);
            return ResponseEntity.ok("Customer updated successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid UUID format:" + e.getMessage());
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        try{
            UUID uuid = UUID.fromString(id);
            String url = baseUrl + "/customers/" + uuid.toString();
            restTemplate.delete(url);
            return ResponseEntity.ok("Customer deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid UUID format:" + e.getMessage());
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/calculate-score/{id}")
    public ResponseEntity<?> calculateScore(@PathVariable String id) {
        try{
            UUID uuid = UUID.fromString(id);
            String url = baseUrl + "/customers/calculate-score" + uuid.toString();
            ResponseEntity<Double> response = restTemplate.getForEntity(url, Double.class);
            return ResponseEntity.ok(response.getBody());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid UUID format:" + e.getMessage());
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
