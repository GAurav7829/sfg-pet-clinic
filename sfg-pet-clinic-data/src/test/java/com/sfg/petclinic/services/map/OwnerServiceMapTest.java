package com.sfg.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sfg.petclinic.model.Owner;

public class OwnerServiceMapTest {

	OwnerServiceMap ownerServiceMap;
	final Long ownerId = 1L;
	final String lastName = "Singh";

	@BeforeEach
	public void setUp() {
		ownerServiceMap = new OwnerServiceMap(new PetTypeMap(), new PetServiceMap());

		Owner owner = new Owner();
		owner.setId(ownerId);
		owner.setLastName(lastName);

		ownerServiceMap.save(owner);
	}

	@Test
	public void findById() {
		Owner owner = ownerServiceMap.findById(ownerId);
		assertEquals(ownerId, owner.getId());
	}

	@Test
	public void findAll() {
		Set<Owner> ownerSet = ownerServiceMap.findAll();
		assertEquals(1, ownerSet.size());
	}

	@Test
	public void save() {
		long id = 2L;

		Owner owner = new Owner();
		owner.setId(id);

		Owner savedOwner = ownerServiceMap.save(owner);

		assertEquals(id, savedOwner.getId());
	}

	@Test
	public void saveNoId() {
		Owner owner = Owner.builder().build();
		Owner savedOwner = ownerServiceMap.save(owner);
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}

	@Test
	public void delete() {
		ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	public void deleteByExistingId() {
		ownerServiceMap.deleteById(ownerId);
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	public void findByLastName() {
		Owner findByLastName = ownerServiceMap.findByLastName(lastName);
		assertEquals(ownerId, findByLastName.getId());
	}
	
	@Test
	public void findByLastNameNotFound() {
		Owner findByLastName = ownerServiceMap.findByLastName("foo");
		assertNull(findByLastName);
	}
}
