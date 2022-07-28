package com.volunteer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping("/index")
	public String viewHomepage() {
		return "index";
	}
	

}
