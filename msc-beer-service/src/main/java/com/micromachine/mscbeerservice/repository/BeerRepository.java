package com.micromachine.mscbeerservice.repository;

import com.micromachine.mscbeerservice.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
