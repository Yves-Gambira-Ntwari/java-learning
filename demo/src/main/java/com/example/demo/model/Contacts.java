package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Contacts")
public class Contacts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long user_id;
	String telephone;
	String username;
	@ManyToOne
	@JoinColumn(name="net_id")
	private TeleNetwork network;
	
	public void setUserId(long user_id) {
		this.user_id = user_id;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setNetwork(TeleNetwork network) {
	    this.network = network;
	}
	
	public long getUserId() {
		return this.user_id ;
	}
	
	public String getTelephone() {
		return this.telephone;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public TeleNetwork getNetwork() {
	    return this.network;
	}

}
