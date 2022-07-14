package com.springrest.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.Travel;

public interface TravelRepo extends JpaRepository<Travel, Integer> {

}
