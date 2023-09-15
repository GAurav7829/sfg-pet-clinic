package com.sfg.petclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sfg.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	Owner findByLastName(String lastName);

	List<Owner> findByLastNameLike(String lastName);
}
