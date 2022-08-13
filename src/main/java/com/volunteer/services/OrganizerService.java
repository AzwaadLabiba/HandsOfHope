package com.volunteer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volunteer.models.Organizer;
import com.volunteer.repositories.OrganizerRepository;

@Service
public class OrganizerService {
	
	@Autowired
	private OrganizerRepository organizerRepository;
	
	public List<Organizer> getAllOrganizers(){
		return organizerRepository.findAll();
	}
	
	public void saveOrganizer(Organizer organizer){
		this.organizerRepository.save(organizer);
	}
	
	public Organizer getOrganizerById(Integer id){
		Optional<Organizer> optional = organizerRepository.findById(id);
		Organizer organizer = null;
		
		if(optional.isPresent()) {
			organizer = optional.get();
		}else {
			throw new RuntimeException(" Organizer not found for id: "+id);
		}
		return organizer;
	}
	
	public void deleteOrganizerById(Integer id){
		this.organizerRepository.deleteById(id);
	}

}
