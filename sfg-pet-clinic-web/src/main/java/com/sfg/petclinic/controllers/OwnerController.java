package com.sfg.petclinic.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping("/{id}")
	public ModelAndView showOwner(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("/owner/ownerDetails");
		modelAndView.addObject(this.ownerService.findById(id));
		return modelAndView;
	}

}
