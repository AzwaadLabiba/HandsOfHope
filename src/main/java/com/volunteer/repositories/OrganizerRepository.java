package com.volunteer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volunteer.models.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {

}
