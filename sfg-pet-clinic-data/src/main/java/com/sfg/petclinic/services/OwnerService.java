package com.sfg.petclinic.services;

import java.util.List;

import com.sfg.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);
	
	List<Owner> findByLastNameLike(String lastName);
	List<Owner> findByLastNameContains(String lastName);
	
	// https://www.baeldung.com/spring-jpa-like-queries
	// https://www.baeldung.com/spring-data-case-insensitive-queries
	// containing method example

}
