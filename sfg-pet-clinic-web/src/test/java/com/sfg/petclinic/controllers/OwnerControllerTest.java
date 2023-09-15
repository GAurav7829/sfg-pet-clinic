package com.sfg.petclinic.controllers;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.hamcrest.Matcher;
import org.hamcrest.beans.HasProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sfg.petclinic.model.Owner;
import com.sfg.petclinic.services.OwnerService;

@ExtendWith(MockitoExtension.class)
public class OwnerControllerTest {

	@Mock
	OwnerService ownerService;
	@InjectMocks
	OwnerController controller;

	Set<Owner> owners;

	MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		owners = new HashSet<>();

		Owner owner1 = new Owner();
		owner1.setId(1L);
		Owner owner2 = new Owner();
		owner2.setId(2L);

		owners.add(owner1);
		owners.add(owner2);

		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

//	@Test
//	public void listOwners() throws Exception {
//		when(ownerService.findAll()).thenReturn(owners);
//		mockMvc.perform(get("/owners")).andExpect(status().isOk()).andExpect(view().name("./owner/index")).andExpect(model().attributeExists("owners"));
//	}
//
//	@Test
//	public void listOwnersAnotherPath() throws Exception {
//		when(ownerService.findAll()).thenReturn(owners);
//		mockMvc.perform(get("/owners/index")).andExpect(status().isOk()).andExpect(view().name("./owner/index")).andExpect(model().attributeExists("owners"));
//	}

	@Test
	public void findOwners() throws Exception {
		mockMvc.perform(get("/owners/find")).andExpect(status().isOk()).andExpect(view().name("notImplemented"));
		verifyNoInteractions(ownerService);
	}

	@Test
	public void displayOwners() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(Owner.builder().address("address").build());
		mockMvc.perform(get("/owners/123")).andExpect(status().isOk()).andExpect(view().name("/owner/ownerDetails"));
//		.andExpect(model().attribute("owner", hasProperty("address"), is("address")));	// not getting hasProperty method
	}

}
