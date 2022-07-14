package com.springrest.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.Adventure;
import com.springrest.springrest.entities.Fashion;

public interface AdventureRepo extends JpaRepository<Adventure, Integer> {

}
