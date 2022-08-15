package com.volunteer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.volunteer.models.CustomUserDetails;
import com.volunteer.repositories.UserRepository;

public class CustomUserDetailService implements UserDetailsService {

	
	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String email ) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		com.volunteer.models.User user = repo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
			
		}
		
		return new CustomUserDetails(user);
	}

}
