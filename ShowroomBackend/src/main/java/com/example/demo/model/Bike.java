package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Bikes_07")
@Data
public class Bike {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "Brand")
	private String brand;
	
	@Column(name = "Model")
	private String model;
	
	@Column(name = "Year")
	private int year;
	
	@Column(name = "Type")
	private String btype;
	
	@Column(name = "Price")
	private String price;

	public Bike(long id, String brand, String model, int year, String btype, String price) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.btype = btype;
		this.price = price;
	}

	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
