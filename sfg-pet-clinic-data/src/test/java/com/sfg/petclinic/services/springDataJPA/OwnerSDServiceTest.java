package com.sfg.petclinic.services.springDataJPA;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sfg.petclinic.model.Owner;
import com.sfg.petclinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
public class OwnerSDServiceTest {

	static final String LAST_NAME = "smith";

	@Mock
	OwnerRepository ownerRepository;
	@InjectMocks
	OwnerSDService ownerSDService;

	Owner returnOwner;

	@BeforeEach
	void setUp() {
		returnOwner = new Owner();
		returnOwner.setId(1L);
		returnOwner.setLastName(LAST_NAME);
	}

	@Test
	public void findById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		
		Owner owner = ownerSDService.findById(1L);
		
		assertNotNull(owner);
	}

	@Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerSDService.findById(1L);

        assertNull(owner);
    }

	@Test
	public void save() {
		Owner ownerToSave = new Owner();
		ownerToSave.setId(1L);

		when(ownerRepository.save(any())).thenReturn(ownerToSave);
		Owner savedOwner = ownerSDService.save(ownerToSave);

		assertNotNull(savedOwner);
		verify(ownerRepository).save(any());
	}

	@Test
	public void findAll() {
		Owner owner1 = new Owner();
		owner1.setId(1L);
		Owner owner2 = new Owner();
		owner2.setId(1L);

		Set<Owner> returnedOwners = new HashSet<>();
		returnedOwners.add(owner1);
		returnedOwners.add(owner2);

		when(ownerRepository.findAll()).thenReturn(returnedOwners);
		Set<Owner> owners = ownerSDService.findAll();

		assertNotNull(owners);
		assertEquals(2, owners.size());

	}

	@Test
	public void delete() {
		ownerSDService.delete(returnOwner);

		verify(ownerRepository, times(1)).delete(any());
	}

	@Test
	public void deleteById() {
		ownerSDService.deleteById(1L);
		verify(ownerRepository, times(1)).deleteById(anyLong());
	}

	@Test
	public void findByLastName() {

		Owner owner = new Owner();
		owner.setLastName(LAST_NAME);

		when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(owner);

		assertEquals(LAST_NAME, ownerSDService.findByLastName(LAST_NAME).getLastName());

		verify(ownerRepository).findByLastName(any());

	}

}
