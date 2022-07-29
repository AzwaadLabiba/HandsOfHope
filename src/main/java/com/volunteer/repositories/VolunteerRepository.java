package com.volunteer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volunteer.models.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer, Integer> {

}
