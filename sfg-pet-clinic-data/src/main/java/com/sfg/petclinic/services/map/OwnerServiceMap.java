package com.sfg.petclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.sfg.petclinic.model.Owner;
import com.sfg.petclinic.model.Pet;
import com.sfg.petclinic.services.OwnerService;
import com.sfg.petclinic.services.PetService;
import com.sfg.petclinic.services.PetTypeService;

@Service
@Profile({ "default", "map" })
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;

	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner save(Owner object) {
		if (null != object) {
			if (null != object.getPets()) {
				object.getPets().forEach(pet -> {
					if (null != pet.getPetType()) {
						if (null == pet.getPetType().getId()) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					} else {
						throw new RuntimeException("Pet Type is required.");
					}
					if (pet.getId() == null) {
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
			return super.save(object);
		} else
			return null;
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
		return this.findAll().stream().filter(owner -> owner.getLastName().equalsIgnoreCase(lastName)).findFirst()
				.orElse(null);
	}

}
