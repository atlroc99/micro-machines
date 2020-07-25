package com.micromachine.mscBreweryClient.web.client;


import com.micromachine.mscBreweryClient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreInvalidFields = false)
public class CustomerClient {

    private String apiHost;
    private String customerApi;
    private RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public void setCustomerApi(String customerApi) {
        this.customerApi = customerApi;
    }

    public CustomerDto getCustomerById(UUID customerId) {
        String url = apiHost + customerApi + "/" + UUID.randomUUID();
        return restTemplate.getForObject(url, CustomerDto.class);
    }

    public URI addCustomer(CustomerDto customerDto) {
        String url = apiHost + customerApi;
        return restTemplate.postForLocation(url, customerDto);
    }

    public void updateCustomer(UUID id, CustomerDto customerDto) {
        restTemplate.put(apiHost + customerApi + "/" + id, customerDto);
    }

    public void deleteCustomer(UUID id) {
        restTemplate.delete(apiHost + customerApi + "/" + id);
    }

}
