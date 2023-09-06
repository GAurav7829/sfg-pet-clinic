package com.sfg.petclinic.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sfg.petclinic.model.Owner;
import com.sfg.petclinic.services.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnerController {

	private final OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}

	@RequestMapping({ "", "/", "/index", "/index.html" })
	public String listOwners(Model model) {
		Set<Owner> owners = ownerService.findAll();
		model.addAttribute("owners", owners);
		return "./owner/index";
	}

	@RequestMapping({ "/find" })
	public String findOwners() {
		return "notImplemented";
	}

}
