package com.sfg.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sfg.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
