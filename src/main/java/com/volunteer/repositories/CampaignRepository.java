package com.volunteer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volunteer.models.Campaign;


public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

}
