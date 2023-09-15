package com.sfg.petclinic.services.springDataJPA;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.sfg.petclinic.model.Owner;
import com.sfg.petclinic.repositories.OwnerRepository;
import com.sfg.petclinic.repositories.PetRepository;
import com.sfg.petclinic.repositories.PetTypeRepository;
import com.sfg.petclinic.services.OwnerService;

@Service
@Profile("springDataJpa")
public class OwnerSDService implements OwnerService {

	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;

	public OwnerSDService(OwnerRepository ownerRepository, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		super();
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		Iterable<Owner> findAll = ownerRepository.findAll();
		findAll.forEach(owners::add);
		return owners;
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

	@Override
	public List<Owner> findByLastNameContains(String lastName) {
		return ownerRepository.findByLastNameContains(lastName);
	}

	@Override
	public List<Owner> findByLastNameLike(String lastName) {
		return ownerRepository.findByLastNameLike("%" + lastName + "%");
	}

}
