package com.volunteer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volunteer.repositories.VolunteerRepository;
import com.volunteer.models.Volunteer;

@Service
public class VolunteerService {
	
	@Autowired
	private VolunteerRepository volunteerRepository;
	
	public List<Volunteer> getAllVolunteers(){
		return volunteerRepository.findAll();
	}
	
	public void saveVolunteer(Volunteer volunteer){
		this.volunteerRepository.save(volunteer);
	}
	
	public Volunteer getVolunteerById(Integer id){
		Optional<Volunteer> optional = volunteerRepository.findById(id);
		Volunteer volunteer = null;
		
		if(optional.isPresent()) {
			volunteer = optional.get();
		}else {
			throw new RuntimeException(" Volunteer not found for id: "+id);
		}
		return volunteer;
	}
	
	public void deleteVolunteerById(Integer id){
		this.volunteerRepository.deleteById(id);
	}

}
