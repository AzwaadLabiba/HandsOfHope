package com.volunteer.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.volunteer.models.Volunteer;
import com.volunteer.services.VolunteerService;

@Controller
public class VolunteerController {
	
	@Autowired
	private VolunteerService volunteerService;
	
	@GetMapping("/volunteer")
	public String viewVolunteerpage(Model model) {
		model.addAttribute("volunteerList", volunteerService.getAllVolunteers());
		return "volunteer";
	}
	
	@PostMapping("/addNewVolunteer")
	public String saveVolunteer(@ModelAttribute("volunteer") Volunteer volunteer){
		//save volunteer
		this.volunteerService.saveVolunteer(volunteer);
		return "redirect:/volunteer";
	}
	
	@GetMapping("/showvolunteerUpdateForm/{id}")
	public String showvolunteerUpdateForm(@PathVariable (value = "id") Integer id, Model model) {
		//get volunteer
		Volunteer volunteer = volunteerService.getVolunteerById(id);
		 
		//set volunteer as a model attribute to pre-populate form
		model.addAttribute("volunteer", volunteer);
		return "volunteerUpdateForm";
	}
	
	@GetMapping("/deleteVolunteer/{id}")
	public String deleteVolunteer(@PathVariable (value = "id") Integer id) {
		this.volunteerService.deleteVolunteerById(id);
		return "redirect:/volunteer";
	}

}
