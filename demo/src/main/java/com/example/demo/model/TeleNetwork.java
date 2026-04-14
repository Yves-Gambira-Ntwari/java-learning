package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tele_network")


public class TeleNetwork {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@Column(name = "network_name", unique=true, length=30)
	String name;
	@OneToMany(mappedBy = "network")
	private List<Contacts> contacts;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return  this.name;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return this.id;
	}
}
