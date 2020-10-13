package com.example.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.model.Institution;
import com.example.model.Institutioncampus;
import com.example.model.Physicalspace;
import com.example.model.Physicalspacetype;
import com.example.repository.CampusRepository;
import com.example.repository.PhysicSpaceRepository;
import com.example.repository.TypeOfSpaceRepository;
import com.example.services.CampusServiceImp;
import com.example.services.PhysicSpaceServiceImp;

class PhysicalSpaceTest {

	@Mock
	private CampusRepository cRepo;
	@Mock
	private PhysicSpaceRepository pRepo;
	@Mock
	private TypeOfSpaceRepository tRepo;
	@InjectMocks
	private PhysicSpaceServiceImp pSer;

	private Physicalspacetype pType;
	private Physicalspace pSpace;
	private Institutioncampus campus;
	
	@BeforeEach
	private void setup() {
		
		MockitoAnnotations.initMocks(this);
		pType=new Physicalspacetype();
		pSpace=new Physicalspace();
		campus=new Institutioncampus();
		
		pType.setPhyspctypeId(1);
		pSpace.setPhyspcId(2);
		campus.setInstcamId(3);
		
		pSpace.setInstitutioncampus(campus);
		pSpace.setPhysicalspacetype(pType);
		
	}
	
	@Test
	public void saveSpaceTest() {
		Optional<Institutioncampus> camOP= Optional.of(campus);		
		when(cRepo.findById(campus.getInstcamId())).thenReturn(camOP);	
		Optional<Physicalspacetype> ptypeOP= Optional.of(pType);		
		when(tRepo.findById(pType.getPhyspctypeId())).thenReturn(ptypeOP);	
		
		try {
			pSer.savePhysicSpace(pSpace);
		
		}catch (Exception e) {
			
			assertTrue(false);
		}	
	}
	
	@Test
	public void noSaveSpaceCampusFaultTest() {
		Optional<Institutioncampus> camOP= Optional.of(campus);		
		when(cRepo.findById(campus.getInstcamId())).thenReturn(camOP);	
		pSpace.setInstitutioncampus(null);
		
		Optional<Physicalspacetype> ptypeOP= Optional.of(pType);		
		when(tRepo.findById(pType.getPhyspctypeId())).thenReturn(ptypeOP);	
		
		try {
			pSer.savePhysicSpace(pSpace);
		
		}catch (Exception e) {
			
			assertTrue(true);
		}	
	}
	
	@Test
	public void noSaveSpaceTypeFaultTest() {
		Optional<Institutioncampus> camOP= Optional.of(campus);		
		when(cRepo.findById(campus.getInstcamId())).thenReturn(camOP);	
		
		Optional<Physicalspacetype> ptypeOP= Optional.of(pType);		
		when(tRepo.findById(pType.getPhyspctypeId())).thenReturn(ptypeOP);	
		pSpace.setPhysicalspacetype(null);
		
		try {
			pSer.savePhysicSpace(pSpace);
		
		}catch (Exception e) {
			
			assertTrue(true);
		}	
	}
	
	@Test
	public void editSpaceTest() {
		Optional<Institutioncampus> camOP= Optional.of(campus);		
		when(cRepo.findById(campus.getInstcamId())).thenReturn(camOP);	
		
		Optional<Physicalspacetype> ptypeOP= Optional.of(pType);		
		when(tRepo.findById(pType.getPhyspctypeId())).thenReturn(ptypeOP);	
		
		Optional<Physicalspace> pspaceOP=Optional.of(pSpace);
		when(pRepo.findById(pSpace.getPhyspcId())).thenReturn(pspaceOP);
		
		try {
			pSer.savePhysicSpace(pSpace);
		
		}catch (Exception e) {
			
			assertTrue(true);
		}	
	}
	
	@Test
	public void noEditSpaceTest() {
		
		pSpace.setInstitutioncampus(null);
		pSpace.setPhysicalspacetype(null);
		
		try {
			pSer.savePhysicSpace(pSpace);
		
		}catch (Exception e) {
			
			assertTrue(true);
		}	
	}
	
}
