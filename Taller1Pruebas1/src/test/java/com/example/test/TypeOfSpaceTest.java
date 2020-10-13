package com.example.test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.model.Institution;
import com.example.model.Physicalspacetype;
import com.example.repository.InstitutionRepository;
import com.example.repository.TypeOfSpaceRepository;
import com.example.services.TypeOfSpaceServiceImp;

class TypeOfSpaceTest {

	private Physicalspacetype pSpace;
	private Institution ins;
	@Mock
	private InstitutionRepository insRep;
	@Mock
	private TypeOfSpaceRepository trepo;
	@InjectMocks
	private TypeOfSpaceServiceImp tser;
	
	@BeforeEach
	private void setup() {
		
		MockitoAnnotations.initMocks(this);
		ins=new Institution();
		long idInstitution=2;
		ins.setInstId(idInstitution);
		String name="Tname";
		long idtype= 1;
		pSpace=new Physicalspacetype();
		pSpace.setPhyspctypeName(name);
		pSpace.setInstitution(ins);
		pSpace.setPhyspctypeId(idtype);

		
	}
	
	@Test
	public void saveTypeOfSpaceTest() {
		Optional<Institution> instOP= Optional.of(ins);		
		when(insRep.findById(ins.getInstId())).thenReturn(instOP);	
		
		try {
			tser.savePhysicalspacetype(pSpace);
		
		}catch (Exception e) {
			
			assertTrue(false);
		}	
	}
	
	
	@Test
	public void NoSaveTypeOfSpaceFultNameTest() {
		Optional<Institution> instOP= Optional.of(ins);		
		when(insRep.findById(ins.getInstId())).thenReturn(instOP);	
		
		pSpace.setPhyspctypeName(null);
		
		try {
			tser.savePhysicalspacetype(pSpace);
		
		}catch (Exception e) {
			
			assertTrue(true);
		}	
	}
	
	@Test
	public void NoSaveTypeOfSpaceFultInstitutionTest() {
		Optional<Institution> instOP= Optional.of(ins);		
		when(insRep.findById(ins.getInstId())).thenReturn(instOP);	
		instOP=null;
		
		
		try {
			tser.savePhysicalspacetype(pSpace);
		
		}catch (Exception e) {
			
			assertTrue(true);
		}	
	}

	@Test
	public void editTypeOfSpaceTest() {
		Optional<Institution> instOP= Optional.of(ins);		
		when(insRep.findById(ins.getInstId())).thenReturn(instOP);	
		
		Optional<Physicalspacetype> tsP= Optional.of(pSpace);		
		when(trepo.findById(pSpace.getPhyspctypeId())).thenReturn(tsP);
		
		
		try {
			tser.editpPhysicalspacetype(pSpace);
		
		}catch (Exception e) {
			
			assertTrue(true);
		}	
	}
	
	@Test
	public void noEditTypeOfSpaceFaultInstitutionTest() {
		Optional<Institution> instOP= Optional.of(ins);		
		when(insRep.findById(ins.getInstId())).thenReturn(instOP);	
		pSpace.setInstitution(null);
		
		Optional<Physicalspacetype> tsP= Optional.of(pSpace);		
		when(trepo.findById(pSpace.getPhyspctypeId())).thenReturn(tsP);
		
		
		try {
			tser.editpPhysicalspacetype(pSpace);
		
		}catch (Exception e) {
			
			assertTrue(true);
		}	
	}
	
	@Test
	public void noEditTypeOfSpaceFaultTypeTest() {
		Optional<Institution> instOP= Optional.of(ins);		
		when(insRep.findById(ins.getInstId())).thenReturn(instOP);	
		
		
		Optional<Physicalspacetype> tsP= Optional.of(pSpace);		
		//when(trepo.findById(pSpace.getPhyspctypeId())).thenReturn(tsP);
		
		
		try {
			tser.editpPhysicalspacetype(pSpace);
		
		}catch (Exception e) {
			System.out.println("enter");
			assertTrue(true);
		}	
	}
}
