package com.micromachine.mscbrewery.services;

import com.micromachine.mscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID id);
    CustomerDto addCustomer(CustomerDto customerDto);
    CustomerDto updateCustomer(UUID id, CustomerDto customerDto);
    void deleteCustomer(UUID id);
}
