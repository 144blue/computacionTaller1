package com.example.integrationTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.model.Institution;
import com.example.model.Institutioncampus;
import com.example.model.Physicalspace;
import com.example.model.Physicalspacetype;
import com.example.repository.CampusRepository;
import com.example.repository.PhysicSpaceRepository;
import com.example.repository.TypeOfSpaceRepository;
import com.example.services.CampusServiceImp;
import com.example.services.PhysicSpaceServiceImp;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class PhysicalSpaceTest {

	@Autowired
	private PhysicSpaceServiceImp pSer;

	private Physicalspacetype pType;
	private Physicalspace pSpace;
	private Institutioncampus campus;
	
	@BeforeEach
	private void setup() {
		
		
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
		
		try {
			pSer.savePhysicSpace(pSpace);
		
		}catch (Exception e) {
			
			assertTrue(false);
		}	
	}
	
	
	@Test
	public void editSpaceTest() {
		
		
		try {
			pSer.savePhysicSpace(pSpace);
			
			pSpace.setPhyspcName("edited");
			pSer.savePhysicSpace(pSpace);
		
		}catch (Exception e) {
			
			assertTrue(true);
		}	
	}
	
	
}
