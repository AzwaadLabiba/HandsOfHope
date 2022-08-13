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
	
	private String date;
	private String method;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPaidby() {
		return paidby;
	}

	public void setPaidby(String paidby) {
		this.paidby = paidby;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPaidto() {
		return paidto;
	}

	public void setPaidto(String paidto) {
		this.paidto = paidto;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public Integer getOrganizer_id() {
		return organizer_id;
	}

	public void setOrganizer_id(Integer organizer_id) {
		this.organizer_id = organizer_id;
	}

	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

	public Integer getSponsor_id() {
		return sponsor_id;
	}

	public void setSponsor_id(Integer sponsor_id) {
		this.sponsor_id = sponsor_id;
	}

	public Volunteer getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(Volunteer volunteer) {
		this.volunteer = volunteer;
	}

	public Integer getVolunteer_id() {
		return volunteer_id;
	}

	public void setVolunteer_id(Integer volunteer_id) {
		this.volunteer_id = volunteer_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	

}
