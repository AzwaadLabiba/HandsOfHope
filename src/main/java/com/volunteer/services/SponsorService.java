package com.volunteer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volunteer.models.Sponsor;
import com.volunteer.repositories.SponsorRepository;

@Service
public class SponsorService {
	
	@Autowired
	private SponsorRepository sponsorRepository;
	
	public List<Sponsor> getAllSponsors(){
		return sponsorRepository.findAll();
	}
	
	public void saveSponsor(Sponsor sponsor){
		this.sponsorRepository.save(sponsor);
	}
	
	public Sponsor getSponsorById(Integer id){
		Optional<Sponsor> optional = sponsorRepository.findById(id);
		Sponsor sponsor = null;
		
		if(optional.isPresent()) {
			sponsor = optional.get();
		}else {
			throw new RuntimeException(" Sponsor not found for id: "+id);
		}
		return sponsor;
	}
	
	public void deleteSponsorById(Integer id){
		this.sponsorRepository.deleteById(id);
	}



}
