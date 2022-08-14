package com.volunteer.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volunteer.models.Role;
import com.volunteer.models.User;
import com.volunteer.repositories.UserRepository;
import com.volunteer.web.dto.UserRegistrationDto;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User save(UserRegistrationDto registrationDto) {
		User user =  new User(registrationDto.getF_name(), registrationDto.getL_name(), registrationDto.getEmail(), registrationDto.getCity(), registrationDto.getContact(), registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
		
	}

}
