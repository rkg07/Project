package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Cars_07")
@Data
public class Car {
	
	@Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Car_Model")
	private String model;
	
	@Column(name = "Car_Brand")
	private String brand;
	
	@Column(name = "Year")
	private int year;
	
	@Column(name = "Type")
	private String ctype;

	@Column(name = "Price")
    private String price;
	
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Car(long id, String model, String brand, int year, String ctype, String price) {
		super();
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.year = year;
		this.ctype = ctype;
		this.price = price;
	}
	
		
	

}
