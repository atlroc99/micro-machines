package com.micromachine.mscBreweryClient.web.client;

import com.micromachine.mscBreweryClient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "sfg.brewery", ignoreInvalidFields = false)     //sfg.brewery.apiHost in teh property files matches apiHost property here
public class BreweryClient {

    private String BEER_PATH_V1 = "/api/v1/beer";
    private String apiHost;
    private RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    
    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public BeerDto getBeerById(UUID id) {
        String uri = apiHost + BEER_PATH_V1 + "/" + id;
        return restTemplate.getForObject(uri+ id, BeerDto.class);
    }

    public URI addBeer(BeerDto beerDto) {
        String url = apiHost + BEER_PATH_V1;
        URI uri = restTemplate.postForLocation(url, beerDto);
        return uri;
    }

    public void updateBeer(UUID id, BeerDto beerDto) {
        String uri = apiHost + BEER_PATH_V1 + "/" + id;
        restTemplate.put(uri, beerDto);
    }

    public void deleteBeer(UUID id) {
        restTemplate.delete(apiHost + BEER_PATH_V1 + "/" + id);
    }

}
