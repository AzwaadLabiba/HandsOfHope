package com.volunteer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volunteer.models.Campaign;
import com.volunteer.repositories.CampaignRepository;

@Service
public class CampaignService {
	
	@Autowired
	private CampaignRepository campaignRepository;
	
	public List<Campaign> getAllCampaigns(){
		return campaignRepository.findAll();
	}
	
	public void saveCampaign(Campaign campaign){
		this.campaignRepository.save(campaign);
	}
	
	public Campaign getCampaignById(Integer id){
		Optional<Campaign> optional = campaignRepository.findById(id);
		Campaign campaign = null;
		
		if(optional.isPresent()) {
			campaign = optional.get();
		}else {
			throw new RuntimeException(" Campaign not found for id: "+id);
		}
		return campaign;
	}
	
	public void deleteCampaignById(Integer id){
		this.campaignRepository.deleteById(id);
	}
}
