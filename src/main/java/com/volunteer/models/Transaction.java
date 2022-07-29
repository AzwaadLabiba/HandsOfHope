package com.volunteer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")


public class Transaction {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String paidby;
	private String amount;
	private String paidto;
	private String transaction_id;
	
	@ManyToOne
	@JoinColumn(name="organizer_id", insertable=false, updatable=false)
	private Organizer organizer;
	private Integer organizer_id;
	
	@ManyToOne
	@JoinColumn(name="sponsor_id", insertable=false, updatable=false)
	private Sponsor sponsor;
	private Integer sponsor_id;
	
	@ManyToOne
	@JoinColumn(name="volunteer_id", insertable=false, updatable=false)
	private Volunteer volunteer;
	private Integer volunteer_id;
	
	private String details;
	

}
