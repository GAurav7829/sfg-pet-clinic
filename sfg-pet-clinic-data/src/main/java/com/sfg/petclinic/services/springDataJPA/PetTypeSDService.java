package com.sfg.petclinic.services.springDataJPA;

import java.util.HashSet;
import java.util.Set;

import com.sfg.petclinic.model.PetType;
import com.sfg.petclinic.repositories.PetTypeRepository;
import com.sfg.petclinic.services.PetTypeService;

public class PetTypeSDService implements PetTypeService {
	
	private final PetTypeRepository petTypeRepository;

	public PetTypeSDService(PetTypeRepository petTypeRepository) {
		super();
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType object) {
		return petTypeRepository.save(object);
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}

}
