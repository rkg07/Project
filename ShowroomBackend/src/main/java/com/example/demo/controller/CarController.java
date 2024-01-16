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
import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CarController {
	
	@Autowired
    private CarRepository carRepository;

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @PostMapping("/cars")
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }
    
    @DeleteMapping("/cars/{id}")
	public ResponseEntity<Map <String, Boolean>> deleteCar(@PathVariable Long id){

		Car car = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car not found for given Id!"));
		
		carRepository.delete(car);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
		
	}
    
    @PutMapping("/cars/{id}")
	public ResponseEntity<Car> updateCar(@RequestBody Car carDetails, @PathVariable Long id ){
		
		Car car = carRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException ("Car not found for given Id!"));
		car.setModel(carDetails.getModel());
		car.setBrand(carDetails.getBrand());
		car.setYear(carDetails.getYear());
		car.setCtype(carDetails.getCtype());
		car.setPrice(carDetails.getPrice());
		       
        Car updateCar=carRepository.save(car);
        return ResponseEntity.ok(updateCar);
	}
    
    @GetMapping("/cars/{id}")
	 public ResponseEntity<Car> getCarById(@PathVariable Long id)
	 {
		 Car car = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car not found for given Id!"));
		 return ResponseEntity.ok(car);
	 }
	


}