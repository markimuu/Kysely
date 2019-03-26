package com.example.Kysely.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KysymysRepository extends CrudRepository<Kysymys, Long> {

    List<Kysymys> findById(long id);
    List<Kysymys> findByKysymys(String kysymys);
    
}