package com.volunteer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VolunteerController {
	
	@GetMapping("/volunteer")
	public String viewVolunteerpage() {
		return "volunteer";
	}

}
