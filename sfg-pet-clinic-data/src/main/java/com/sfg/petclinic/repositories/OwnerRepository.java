package com.sfg.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sfg.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
