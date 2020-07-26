package com.micromachine.mscbrewery.web.Mapper;

import com.micromachine.mscbrewery.domain.Beer;
import com.micromachine.mscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
