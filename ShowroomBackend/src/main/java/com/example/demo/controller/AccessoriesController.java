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
import com.example.demo.model.Accessories;
import com.example.demo.model.Car;
import com.example.demo.repository.AccessoriesRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AccessoriesController {
	
	@Autowired
	private AccessoriesRepo arepo;
	
	@GetMapping("/accessories")
    public List<Accessories> getAllAccessories() {
        return arepo.findAll();
    }

    @PostMapping("/accessories")
    public Accessories createAccessories(@RequestBody Accessories accessories) {
        return arepo.save(accessories);
    }
    
    @DeleteMapping("/accessories/{id}")
	public ResponseEntity<Map <String, Boolean>> deleteAccessories(@PathVariable Long id){

    	Accessories acc = arepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Accessories not found for given Id!"));
		
		arepo.delete(acc);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
		
	}
    
    @PutMapping("/accessories/{id}")
	public ResponseEntity<Accessories> updateAccessories(@RequestBody Accessories accessoriesDetails, @PathVariable Long id ){
		
    	Accessories acc = arepo.findById(id).orElseThrow(()-> new ResourceNotFoundException ("Accessories not found for given Id!"));
		acc.setName(accessoriesDetails.getName());
		acc.setPrice(accessoriesDetails.getPrice());
		acc.setImage(accessoriesDetails.getImage());
    
		       
		Accessories updateAccessories=arepo.save(acc);
        return ResponseEntity.ok(updateAccessories);
	}
    
    @GetMapping("/accessories/{id}")
	 public ResponseEntity<Accessories> getAccessoriesById(@PathVariable Long id)
	 {
    	Accessories acc = arepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Accessories not found for given Id!"));
		 return ResponseEntity.ok(acc);
	 }
	


}