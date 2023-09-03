package com.sfg.petclinic.services.map;

import java.util.Set;

import com.sfg.petclinic.model.Owner;
import com.sfg.petclinic.services.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}
	
	public Set<Owner> findAll(){
		return super.findAll();
	}

	@Override
	public Owner save(Owner object) {
		return super.save(object.getId(), object);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
	public Owner findByLastName(String lastName) {
		return null;
	}

}
