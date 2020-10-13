package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Physicalspace;
@Repository
public interface PhysicSpaceRepository extends CrudRepository<Physicalspace, Long>{

}
