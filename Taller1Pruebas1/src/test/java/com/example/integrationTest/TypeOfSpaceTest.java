package com.example.integrationTest;

import static org.hamcrest.CoreMatchers.nullValue;
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
import com.example.model.Physicalspacetype;
import com.example.repository.InstitutionRepository;
import com.example.repository.TypeOfSpaceRepository;
import com.example.services.TypeOfSpaceServiceImp;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class TypeOfSpaceTest {

	private Physicalspacetype pSpace;
	private Institution ins;
	
	@Autowired
	private TypeOfSpaceServiceImp tser;
	
	@BeforeEach
	private void setup() {
		
		
		
		
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
		
		
		try {
			tser.savePhysicalspacetype(pSpace);
		
		}catch (Exception e) {
			e.printStackTrace();
			fail();
		}	
	}
	
	     

	@Test
	public void editTypeOfSpaceTest() {
		
				
		try {
			tser.savePhysicalspacetype(pSpace);
			pSpace.setPhyspctypeName("edited");
			tser.editpPhysicalspacetype(pSpace);
		
		}catch (Exception e) {
			
			fail();
		}	
	}
	
	
}
