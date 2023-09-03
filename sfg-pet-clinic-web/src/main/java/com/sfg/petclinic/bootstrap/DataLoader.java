package com.sfg.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sfg.petclinic.model.Owner;
import com.sfg.petclinic.model.Vet;
import com.sfg.petclinic.services.OwnerService;
import com.sfg.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	public DataLoader(OwnerService ownerService, VetService vetService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner();
		owner1.setFirstName("Gaurav");
		owner1.setLastName("Singh");
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Saurav");
		owner2.setLastName("Singh");
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
