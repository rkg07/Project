package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Accessories_07")
@Data
public class Accessories {
	
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name = "price")
    private String price;
	
	@Column(name = "Image")
	private String image;

	
	public Accessories() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Accessories(long id, String name, String price, String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
	}
	
	

	
	

}
