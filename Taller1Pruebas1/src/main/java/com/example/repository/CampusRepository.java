package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Institutioncampus;
@Repository
public interface CampusRepository extends CrudRepository<Institutioncampus, Long>{

	
}
