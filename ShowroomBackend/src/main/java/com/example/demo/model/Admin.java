package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="Admin_07")
public class Admin
{
	@Id
	private int id;
	
	@Column(name="Username")
	private String username;
 
	@Column(name="Password")
	private String password;
	
	
	public Admin() {
		super();
	// TODO Auto-generated constructor stub

	}
	
	public Admin(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		
	}
 
}