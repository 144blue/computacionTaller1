package com.example.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Physicalspacetype;

@Repository
public interface TypeOfSpaceRepository extends CrudRepository<Physicalspacetype, Long>{

}
