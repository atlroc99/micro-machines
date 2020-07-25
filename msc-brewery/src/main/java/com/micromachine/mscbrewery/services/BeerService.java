package com.micromachine.mscbrewery.services;

import com.micromachine.mscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID id);
    BeerDto addNewBeer(BeerDto beerDto);
    BeerDto updateBeer(UUID id, BeerDto beerDto);
    BeerDto deleteBeer(UUID id);
}
