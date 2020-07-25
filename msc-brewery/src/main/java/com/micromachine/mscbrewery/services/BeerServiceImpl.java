package com.micromachine.mscbrewery.services;

import com.micromachine.mscbrewery.web.model.BeerDto;
import org.apache.commons.math.random.RandomData;
import org.apache.commons.math.random.RandomDataImpl;
import org.apache.commons.math.random.RandomGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID id) {

        long leftMin = 1L;
        long rightMax = 100L;
        Long upc = new RandomDataImpl().nextLong(leftMin, rightMax);

        return BeerDto.builder()
                .id(id)
                .upc(upc)
                .beerName("CocaCola")
                .beerStyle("Some style")
                .build();
    }
}
