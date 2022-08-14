package com.volunteer.services;


import com.volunteer.models.User;
import com.volunteer.web.dto.UserRegistrationDto;


public interface UserService{
	User save(UserRegistrationDto registrationDto);
	

}
