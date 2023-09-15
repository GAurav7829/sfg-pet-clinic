package com.sfg.petclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sfg.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	Owner findByLastName(String lastName);

	List<Owner> findByLastNameLike(String lasatName);
	List<Owner> findByLastNameContains(String lastName);

	// https://www.baeldung.com/spring-jpa-like-queries
	// https://www.baeldung.com/spring-data-case-insensitive-queries
	// containing method example
}
