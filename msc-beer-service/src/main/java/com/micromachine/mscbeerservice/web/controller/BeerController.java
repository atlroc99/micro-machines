package com.micromachine.mscbeerservice.web.controller;

import com.micromachine.mscbeerservice.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    @Value("${hostAndPort}")
    private String hostAndPort;

    @Value("${beer.apiPath}")
    private String beerApipath;


    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) throws Exception{
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addBeer(@RequestBody BeerDto beerDto) throws Exception{
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable UUID beerId, @RequestBody BeerDto beerDto) throws Exception {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity deleteBeer(@PathVariable UUID beerId) throws Exception {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
