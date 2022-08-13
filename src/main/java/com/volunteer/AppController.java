package com.volunteer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@GetMapping("/index")
	public String viewHomepage() {
		return "index";
	}
	
	@GetMapping("/admin")
	public String viewAdminpage() {
		return "admin";
	}


}
