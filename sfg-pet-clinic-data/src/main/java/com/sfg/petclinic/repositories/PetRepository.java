package com.sfg.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sfg.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
