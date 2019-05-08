package com.example.Kysely.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VastausRepository extends CrudRepository<Vastaus, Long> {

    List<Vastaus> findByVastausid(long vastausid);
    List<Vastaus> findByVastausteksti(String vastausteksti);
    
}