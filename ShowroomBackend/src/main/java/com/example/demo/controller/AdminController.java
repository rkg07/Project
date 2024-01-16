package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Admin;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {
    // Hardcoding the admin credentials
    private static final String EXPECTED_USERNAME = "admin";
    private static final String EXPECTED_PASSWORD = "admin";
    // A simple flag to track the login status
    private boolean isLoggedIn = false;
    
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> adminLogin(@RequestBody Admin admin) {
        // Check if the provided credentials match the hardcoded admin credentials
        if (EXPECTED_USERNAME.equals(admin.getUsername()) && EXPECTED_PASSWORD.equals(admin.getPassword())) {
            // Set the login status to true
            isLoggedIn = true;
            // Return a success message if credentials are correct
            Map<String, String> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "Admin login successful");
            return ResponseEntity.ok(response);
        } else {
            // Return an error message if credentials are incorrect
            Map<String, String> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", "Admin not found");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> adminLogout() {
        // Set the login status to false
        isLoggedIn = false;
        // Return a success message for logout
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Admin logout successful");
        return ResponseEntity.ok(response);
    }
}