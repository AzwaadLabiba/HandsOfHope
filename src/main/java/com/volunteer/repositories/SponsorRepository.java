package com.volunteer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volunteer.models.Sponsor;

public interface SponsorRepository extends JpaRepository<Sponsor, Integer> {

}
