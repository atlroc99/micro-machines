package com.micromachine.mscbrewery.web.controller;

import com.micromachine.mscbrewery.services.BeerService;
import com.micromachine.mscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final String hostAndPort = "http://localhost:8080";
    private final String apiPath = "/api/v1/beer";

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId) {
        BeerDto beerDto = beerService.getBeerById(beerId);
        return new ResponseEntity<>(beerDto, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity addBeer(@RequestBody BeerDto beerDto) {
        BeerDto newBeer = beerService.addNewBeer(beerDto);

        //sending location of the newly created / added beer in HttpHeaders
        HttpHeaders httpHeaders = new HttpHeaders();
        String beerLocation = hostAndPort + apiPath + "/"+ newBeer.getId();
        httpHeaders.add("Location", beerLocation);
        
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@Nullable @PathVariable UUID beerId, @RequestBody BeerDto beerDto) {
        BeerDto updatedBeer = beerService.updateBeer(beerId, beerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Location", hostAndPort + apiPath + "/" + updatedBeer.getId());
        return new ResponseEntity(httpHeaders, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity<BeerDto> deleteBeer(@PathVariable UUID beerId){
        return new ResponseEntity<>(beerService.deleteBeer(beerId), HttpStatus.NO_CONTENT);
    }
}

