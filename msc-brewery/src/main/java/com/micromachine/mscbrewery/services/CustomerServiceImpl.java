package com.micromachine.mscbrewery.services;

import com.micromachine.mscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Jon Rambo")
                .build();
    }

    @Override
    public CustomerDto addCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name(customerDto.getName())
                .build() ;
    }

    @Override
    public CustomerDto updateCustomer(UUID id, CustomerDto customerDto) {
        CustomerDto existingCustomer = getCustomerById(id);
        existingCustomer.setName(customerDto.getName());
        return existingCustomer;
    }

    @Override
    public void deleteCustomer(UUID id) {
        CustomerDto deleted = getCustomerById(id);
        System.out.println("customer delted" + deleted.getName());
    }
}
