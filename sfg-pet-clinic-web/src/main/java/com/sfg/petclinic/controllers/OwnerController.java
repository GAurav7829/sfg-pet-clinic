package com.sfg.petclinic.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@InitBinder
	public void setAllowedFields(WebDataBinder webDataBinder) { // control form post in more detail, use this method
		webDataBinder.setDisallowedFields("id");
	}

//	@RequestMapping({ "", "/", "/index", "/index.html" })
//	public String listOwners(Model model) {
//		Set<Owner> owners = ownerService.findAll();
//		model.addAttribute("owners", owners);
//		return "./owner/index";
//	}

	@RequestMapping({ "/find" })
	public String findOwners(Model model) {
		model.addAttribute("owner", Owner.builder().build());
		return "/owner/findOwners";
	}

	@GetMapping("")
	public String processFindForm(Owner owner, BindingResult result, Model model) {
		if (null == owner.getLastName())
			owner.setLastName("");

		List<Owner> ownersByLastName = ownerService.findByLastNameLike(owner.getLastName());
		if (ownersByLastName.isEmpty()) {
			result.rejectValue("lastName", "notFound", "not found");
			return "/owner/findOwners";
		} else if (ownersByLastName.size() == 1) {
			Owner ownerFound = ownersByLastName.get(0);
			return "redirect:/owners/" + ownerFound.getId();
		} else {
			model.addAttribute("listOwners", ownersByLastName);
			return "/owner/ownersList";
		}
	}

	@GetMapping("/{id}")
	public ModelAndView showOwner(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("/owner/ownerDetails");
		modelAndView.addObject(this.ownerService.findById(id));
		return modelAndView;
	}

	@GetMapping("/new")
	public String initCreationForm(Model model) {
		model.addAttribute("owner", Owner.builder().build());
//		model.addAttribute("isNew", true);
		return "owner/createOrUpdateOwnerForm";
	}

	@PostMapping("/new")
	public String processCreationForm(@ModelAttribute Owner owner, BindingResult result) {
		if (result.hasErrors())
			return "owner/createOrUpdateOwnerForm";
		else {
			Owner savedOwner = ownerService.save(owner);
			return "redirect:/owners/" + savedOwner.getId();
		}
	}

	@GetMapping("/{id}/edit")
	public String initUpdateOwnerForm(@PathVariable String id, Model model) {
		Owner owner = ownerService.findById(Long.valueOf(id));
		model.addAttribute("owner", owner);
//		model.addAttribute("isNew", false);
		return "owner/createOrUpdateOwnerForm";
	}

	@PostMapping("/{id}/edit")
	public String processUpdateOwnerForm(@PathVariable String id, Owner owner, BindingResult result, Model model) {
		if (result.hasErrors())
			return "owner/createOrUpdateOwnerForm";
		
		owner.setId(Long.valueOf(id));	// as we add @InitBinder to prevent id
		Owner savedOwner = ownerService.save(owner);
		return "redirect:/owners/" + savedOwner.getId();
	}

}
