package com.sfg.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sfg.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
