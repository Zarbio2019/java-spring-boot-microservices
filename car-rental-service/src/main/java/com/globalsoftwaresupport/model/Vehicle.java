package com.globalsoftwaresupport.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.pesistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Id;

@Entity
public class Vehicle {
	@Id
	@GenerateValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private Status status;
	
	@Column(length = 30)
	private String owner;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 30)
	@JsonProperty("association_date")
	private Date associationDate;
	
	public Vehicle() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getAssociationDate() {
		return associationDate;
	}

	public void setAssociationDate(Date associationDate) {
		this.associationDate = associationDate;
	}
}
