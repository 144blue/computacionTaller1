package com.example.services;

import com.example.model.Institution;

public interface InstitutionService {

	public Institution saveInstitution(Institution ins) throws Exception;
	public Institution editInstitution(Institution ins) throws Exception;
	
}
