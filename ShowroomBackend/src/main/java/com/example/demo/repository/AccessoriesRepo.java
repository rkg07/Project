package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Accessories;

public interface AccessoriesRepo extends JpaRepository <Accessories , Long> {

}
