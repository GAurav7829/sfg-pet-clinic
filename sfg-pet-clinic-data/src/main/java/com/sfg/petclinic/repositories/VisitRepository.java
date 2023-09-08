package com.sfg.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sfg.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
