package com.example.Kysely.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KyselyRepository extends CrudRepository<Kysely, Long> {

    List<Kysely> findByKyselyid(long kyselyid);
    List<Kysely> findByOtsikko(String otsikko);
    List<Kysely> findByKuvaus(String kuvaus);
    
}