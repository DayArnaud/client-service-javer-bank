package io.github.dayanearnaud.client_service_javer_bank.clients;

import io.github.dayanearnaud.client_service_javer_bank.model.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "CustomerService", url = "http://manager-deploy-env.eba-w9ims9yz.us-east-1.elasticbeanstalk.com")
public interface CustomerServiceClient {

    @PostMapping("/customers/")
    CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO);

    @GetMapping("/customers/{id}")
    CustomerDTO getCustomerById(@PathVariable("id")UUID id);

    @GetMapping("/customers/")
    List<CustomerDTO> getAllCustomers();

    @PutMapping("/customers/{id}")
    CustomerDTO updateCustomer(@PathVariable("id") UUID id, @RequestBody CustomerDTO customerDTO);

    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable("id") UUID id);

    @GetMapping("/customers/calculate-score/{id}")
    Double calculateCreditScore(@PathVariable("id") UUID id);
}
