package com.springrest.springrest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springrest.springrest.entities.Health;

public interface HealthRepo extends JpaRepository<Health, Integer> {

}
