package com.example.services;

import com.example.model.Institutioncampus;

public interface CampusService {

	public Institutioncampus saveCampus(Institutioncampus icampus) throws Exception;
	public Institutioncampus editCampus(Institutioncampus icampus) throws Exception;
}
