package com.springrest.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.Fashion;

public interface FashionRepo extends JpaRepository<Fashion, Integer> {

}
