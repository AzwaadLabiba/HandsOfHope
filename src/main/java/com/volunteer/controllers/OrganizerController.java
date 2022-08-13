package com.volunteer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.volunteer.models.Organizer;
import com.volunteer.services.OrganizerService;

@Controller
public class OrganizerController {
	
	@Autowired
	private OrganizerService organizerService;
	
	@GetMapping("/organizer")
	public String viewOrganizerpage(Model model) {
		model.addAttribute("organizerList", organizerService.getAllOrganizers());
		return "organizer";
	}
	
	@PostMapping("/addNewOrganizer")
	public String saveOrganizer(@ModelAttribute("organizer") Organizer organizer){
		//save organizer
		this.organizerService.saveOrganizer(organizer);
		return "redirect:/organizer";
	}
	
	@GetMapping("/showorganizerUpdateForm/{id}")
	public String showorganizerUpdateForm(@PathVariable (value = "id") Integer id, Model model) {
		//get Organizer
		Organizer organizer = organizerService.getOrganizerById(id);
		 
		//set Organizer as a model attribute to pre-populate form
		model.addAttribute("organizer", organizer);
		return "organizerUpdateForm";
	}
	
	@GetMapping("/deleteOrganizer/{id}")
	public String deleteOrganizer(@PathVariable (value = "id") Integer id) {
		this.organizerService.deleteOrganizerById(id);
		return "redirect:/organizer";
	}

}
