package com.springrest.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.Fashion;
import com.springrest.springrest.entities.Photography;

public interface PhotographyRepo extends JpaRepository<Photography, Integer> {

}
