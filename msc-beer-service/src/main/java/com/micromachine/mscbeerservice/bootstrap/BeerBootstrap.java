package com.micromachine.mscbeerservice.bootstrap;

import com.micromachine.mscbeerservice.domain.Beer;
import com.micromachine.mscbeerservice.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerBootstrap implements CommandLineRunner {

    private BeerRepository beerRepository;

    public BeerBootstrap(BeerRepository beerRepository ) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) {
        if (beerRepository.count() == 0) {
            beerRepository.save(
                    Beer.builder()
                            .beerName("Galaxy Cat")
                            .beerStyle("Pale Ale")
                            .price(new BigDecimal(6000))
                            .quantityToBrew(200)
                            .minOnHand(15)
                            .upc(124544L)
                            .build());
            beerRepository.save( Beer.builder()
                    .beerName("Mango Bob")
                    .beerStyle("IPC")
                    .price(new BigDecimal(5700))
                    .quantityToBrew(500)
                    .minOnHand(12)
                    .upc(1244L)
                    .build());
        }

        System.out.println("Total number of beer: " + beerRepository.count());
    }

}
