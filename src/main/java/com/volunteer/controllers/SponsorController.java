package com.volunteer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.volunteer.models.Sponsor;
import com.volunteer.services.SponsorService;

@Controller
public class SponsorController {
	
	@Autowired
	private SponsorService sponsorService;
	
	@GetMapping("/sponsor")
	public String viewSponsorpage(Model model) {
		model.addAttribute("sponsorList", sponsorService.getAllSponsors());
		return "sponsor";
	}
	
	@PostMapping("/addNewSponsor")
	public String saveSponsor(@ModelAttribute("sponsor") Sponsor sponsor){
		//save sponsor
		this.sponsorService.saveSponsor(sponsor);
		return "redirect:/sponsor";
	}
	
	@GetMapping("/showsponsorUpdateForm/{id}")
	public String showsponsorUpdateForm(@PathVariable (value = "id") Integer id, Model model) {
		//get sponsor
		Sponsor sponsor = sponsorService.getSponsorById(id);
		 
		//set sponsor as a model attribute to pre-populate form
		model.addAttribute("sponsor", sponsor);
		return "sponsorUpdateForm";
	}
	
	@GetMapping("/deleteSponsor/{id}")
	public String deleteSponsor(@PathVariable (value = "id") Integer id) {
		this.sponsorService.deleteSponsorById(id);
		return "redirect:/sponsor";
	}

}
