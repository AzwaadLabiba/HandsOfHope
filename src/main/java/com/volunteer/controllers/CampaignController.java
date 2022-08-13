package com.volunteer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.volunteer.models.Campaign;
import com.volunteer.services.CampaignService;

@Controller
public class CampaignController {
	
	@Autowired
	private CampaignService campaignService;
	
	@GetMapping("/ongoing_campaigns")
	public String viewOngoingCampaignpage(Model model) {
		model.addAttribute("campaignsList", campaignService.getAllCampaigns());
		return "ongoing_campaigns";
	}
	
	@PostMapping("/addNewCampaign")
	public String saveCampaign(@ModelAttribute("campaign") Campaign campaign){
		//save campaign
		this.campaignService.saveCampaign(campaign);
		return "redirect:/ongoing_campaigns";
	}
	
	@GetMapping("/showcampaignUpdateForm/{id}")
	public String showcampaignUpdateForm(@PathVariable (value = "id") Integer id, Model model) {
		//get campaign
		Campaign campaign = campaignService.getCampaignById(id);
		 
		//set campaign as a model attribute to pre-populate form
		model.addAttribute("campaign", campaign);
		return "campaignUpdateForm";
	}
	
	@GetMapping("/deleteCampaign/{id}")
	public String deleteCampaign(@PathVariable (value = "id") Integer id) {
		this.campaignService.deleteCampaignById(id);
		return "redirect:/ongoing_campaigns";
	}
	
	
//	@GetMapping("/previous_campaigns")
//	public String viewPreviousCampaignspage() {
//		return "previous_campaigns";
//	}
//	
//	@GetMapping("/upcoming_campaigns")
//	public String viewUpcomingCampaignspage() {
//		return "upcoming_campaigns";
//	}

}
