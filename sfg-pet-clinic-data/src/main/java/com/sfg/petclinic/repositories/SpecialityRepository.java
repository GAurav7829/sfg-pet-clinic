package com.sfg.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sfg.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

}
