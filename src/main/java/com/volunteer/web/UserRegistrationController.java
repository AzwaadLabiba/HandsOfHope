package com.volunteer.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.volunteer.services.UserServiceImpl; 
import com.volunteer.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	private UserServiceImpl userService;

	public UserRegistrationController(UserServiceImpl userService) {
		super();
		this.userService = userService;
	} 
	
//	@ModelAttribute("user")
//	public UserRegistrationDto userRegistrationDto() {
//		return new UserRegistrationDto();
//	}
	
	@GetMapping()
	public String showRegistrationForm(Model model){
		model.addAttribute("user", new UserRegistrationDto());
		return "registration";
	}
	
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(registrationDto.getPassword());
		registrationDto.setPassword(encodedPassword);
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
 
}
