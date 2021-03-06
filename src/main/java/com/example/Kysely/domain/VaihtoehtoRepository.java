package com.example.Kysely.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VaihtoehtoRepository extends CrudRepository<Vaihtoehto, Long>{
	
	List<Vaihtoehto> findByVaihtoehtoId(long vaihtoehtoId);
	List<Vaihtoehto> findByVaihtoehto(String vaihtoehto);
	List<Vaihtoehto> findByJarjestusnumero(long jarjestusnumero);
	
}
