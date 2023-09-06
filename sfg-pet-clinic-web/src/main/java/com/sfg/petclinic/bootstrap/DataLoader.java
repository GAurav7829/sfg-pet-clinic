package com.sfg.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sfg.petclinic.model.Owner;
import com.sfg.petclinic.model.Pet;
import com.sfg.petclinic.model.PetType;
import com.sfg.petclinic.model.Vet;
import com.sfg.petclinic.services.OwnerService;
import com.sfg.petclinic.services.PetTypeService;
import com.sfg.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Pet brutus = new Pet();
		brutus.setName("brutus");
		brutus.setPetType(savedDogPetType);
		brutus.setDateOfBirth(LocalDate.now());
		
		Pet pixie = new Pet();
		pixie.setName("pixie");
		pixie.setPetType(savedCatPetType);
		pixie.setDateOfBirth(LocalDate.now());
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Gaurav");
		owner1.setLastName("Singh");
		owner1.setAddress("address 1");
		owner1.setCity("Delhi");
		owner1.setTelephone("0123456789");
		owner1.getPets().add(brutus);
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Saurav");
		owner2.setLastName("Singh");
		owner1.setAddress("address 2");
		owner1.setCity("Delhi");
		owner1.setTelephone("0123456788");
		owner2.getPets().add(pixie);
		ownerService.save(owner2);

		System.out.println("Owner Loaded.......");

		Vet vet1 = new Vet();
		vet1.setFirstName("Dr. Gaurav");
		vet1.setLastName("Singh");
		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Dr. Saurav");
		vet2.setLastName("Singh");
		vetService.save(vet2);

		System.out.println("Vets Loaded...........");
	}

}
