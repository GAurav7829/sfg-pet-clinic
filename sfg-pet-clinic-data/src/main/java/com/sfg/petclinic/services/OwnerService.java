package com.sfg.petclinic.services;

import java.util.List;

import com.sfg.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);
	
	List<Owner> findByLastNameLike(String lastName);
	
	// https://www.baeldung.com/spring-jpa-like-queries
	// containing method example

}
