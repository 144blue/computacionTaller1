package com.example.test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.model.Institution;
import com.example.model.Institutioncampus;
import com.example.repository.CampusRepository;
import com.example.repository.InstitutionRepository;
import com.example.services.CampusServiceImp;

class CampusTest {

	private Institution ins;
	private Institutioncampus campus;
	@Mock
	private CampusRepository camRep;
	@Mock
	private InstitutionRepository insRep;
	@InjectMocks
	private CampusServiceImp camSer;
	
	@BeforeEach
	private void setup() {
		
		MockitoAnnotations.initMocks(this);
		ins=new Institution();
		campus=new Institutioncampus();
		campus.setInstitution(ins);
		String name=("campuss");
		long idCampus= 1;
		long idInstitution=2;
		ins.setInstId(idInstitution);
		campus.setInstcamId(idCampus);
		campus.setInstcamName(name);
		campus.setInstcamOccupation(BigDecimal.valueOf(0));
		
	}
	
	@Test
	public void saveCampusTest() {
		Optional<Institution> instOP= Optional.of(ins);		
		when(insRep.findById(ins.getInstId())).thenReturn(instOP);	
		
		try {
			camSer.saveCampus(campus);
		
		}catch (Exception e) {
			
			assertTrue(false);
		}	
	}
	
	@Test
	public void noSaveCampusFultNameTest() {
		
		campus.setInstcamName(null);
		
		Optional<Institution> instOP= Optional.of(ins);		
		when(insRep.findById(ins.getInstId())).thenReturn(instOP);	
		
		try {
			camSer.saveCampus(campus);
		
		}catch (Exception e) {
			
			assertTrue(true);
		}	
	}
	
	@Test
	public void noSaveCampusFultInstitutionTest() {
		
		Optional<Institution> instOP= Optional.of(ins);		
		when(insRep.findById(ins.getInstId())).thenReturn(instOP);	
		instOP=null;
		
		try {
			camSer.saveCampus(campus);
		
		}catch (Exception e) {
			
			assertTrue(true);
		}	
	}
	
	@Test
	public void noSaveCampusFultOcupationTest() {
		
		Optional<Institution> instOP= Optional.of(ins);		
		when(insRep.findById(ins.getInstId())).thenReturn(instOP);	
		campus.setInstcamOccupation(BigDecimal.valueOf(23));
		
		try {
			camSer.saveCampus(campus);
		
		}catch (Exception e) {
			
			assertTrue(true);
		}	
	}
	
	@Test
	public void editCampusTest() {
		
		Optional<Institution> instOP= Optional.of(ins);		
		when(insRep.findById(ins.getInstId())).thenReturn(instOP);	
		
		Optional<Institutioncampus> instca= Optional.of(campus);		
		when(camRep.findById(campus.getInstcamId())).thenReturn(instca);	
		
		
		try {
			camSer.editCampus(campus);
		
		}catch (Exception e) {
			
			assertTrue(false);
		}	
	}
	
	@Test
	public void noEditCampusTest() {
		
		Optional<Institution> instOP= Optional.of(ins);		
		when(insRep.findById(ins.getInstId())).thenReturn(instOP);	
		campus.setInstitution(null);
		
		Optional<Institutioncampus> instca= Optional.of(campus);		
		when(camRep.findById(campus.getInstcamId())).thenReturn(instca);	
		
		
		try {
			camSer.editCampus(campus);
		
		}catch (Exception e) {
			
			assertTrue(true);
		}	
	}
	
}
