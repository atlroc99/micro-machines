package com.micromachine.mscbrewery.web.controller;

import com.micromachine.mscbrewery.services.CustomerService;
import com.micromachine.mscbrewery.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

    @Value("${hostAndPort}")
    private String hostAndPort;

    @Value("${customer.apiPath}")
    private String apiPath;
    
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpHeaders> addCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto newCustomer = customerService.addCustomer(customerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", hostAndPort + apiPath + "/" + newCustomer.getId());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<HttpHeaders> updateCustomer(@PathVariable UUID customerId, @RequestBody CustomerDto customerDto) {
        CustomerDto updatedCustomer = customerService.updateCustomer(customerId, customerDto);
                HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", hostAndPort + apiPath + "/" + updatedCustomer.getId());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/{customerId")
    public ResponseEntity deleteCustomer(@PathVariable UUID customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }
}
