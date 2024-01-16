package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Bike;
import com.example.demo.repository.BikeRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BikeController {
	
	@Autowired
    private BikeRepository bikeRepository;

    @GetMapping("/bikes")
    public List<Bike> getAllBike() {
        return bikeRepository.findAll();
    }

    @PostMapping("/bikes")
    public Bike createBike(@RequestBody Bike bike) {
        return bikeRepository.save(bike);
    }
    
    @DeleteMapping("/bikes/{id}")
	public ResponseEntity<Map <String, Boolean>> deleteBike(@PathVariable Long id){

		Bike bike = bikeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bike not found for given Id!"));
		
		bikeRepository.delete(bike);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
		
	}
    
    @PutMapping("/bikes/{id}")
   	public ResponseEntity<Bike> updateBike(@RequestBody Bike bikeDetails, @PathVariable Long id ){
   		
   		Bike bike = bikeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException ("Bike not found for given Id!"));
   		bike.setBrand(bikeDetails.getBrand());
   		bike.setModel(bikeDetails.getModel());
   		bike.setYear(bikeDetails.getYear());
   		bike.setBtype(bikeDetails.getBtype());
   		bike.setPrice(bikeDetails.getPrice());
   		
   		Bike updateBike=bikeRepository.save(bike);
   		return ResponseEntity.ok(updateBike);
   	}
    
    @GetMapping("/bikes/{id}")
	 public ResponseEntity<Bike> getBikeById(@PathVariable Long id)
	 {
		 Bike bike = bikeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bike not found for given Id!"));
		 return ResponseEntity.ok(bike);
	 }
	
	

}
