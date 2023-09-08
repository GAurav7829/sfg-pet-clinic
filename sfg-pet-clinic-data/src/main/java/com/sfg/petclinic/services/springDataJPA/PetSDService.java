package com.sfg.petclinic.services.springDataJPA;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.sfg.petclinic.model.Pet;
import com.sfg.petclinic.repositories.PetRepository;
import com.sfg.petclinic.services.PetService;

@Service
@Profile("springDataJpa")
public class PetSDService implements PetService {
	
	private final PetRepository petRepository;

	public PetSDService(PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet object) {
		return petRepository.save(object);
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}

}
