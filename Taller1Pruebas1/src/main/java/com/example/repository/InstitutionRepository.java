package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Institution;
@Repository
public interface InstitutionRepository extends CrudRepository<Institution, Long>{

}
