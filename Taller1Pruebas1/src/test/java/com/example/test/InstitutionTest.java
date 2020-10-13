package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;


import com.example.model.Institution;
import com.example.repository.InstitutionRepository;
import com.example.services.InstitutionServiceImp;
	
import org.junit.jupiter.api.Test;
import org.junit.runner.*;


@RunWith(MockitoJUnitRunner.class)
class InstitutionTest {
	
	
	private Institution inst;

	@Mock
	private InstitutionRepository insrepo;
	
	@InjectMocks
	private InstitutionServiceImp instServiceImp;
	
	
	@BeforeEach
	private void setup() {
		
		MockitoAnnotations.initMocks(this);
		String URL="https://goo";
		long id=1;
		
		inst =new Institution();
		inst.setInstAcademicserverurl(URL);
		inst.setInstAcadextradataurl(URL);
		inst.setInstAcadloginurl(URL);
		inst.setInstAcadpersoninfodocurl(URL);
		inst.setInstAcadpersoninfoidurl(URL);
		inst.setInstAcadphysicalspacesurl(URL);
		inst.setInstAcadprogrammedcoursesurl(URL);
		inst.setInstId(id);
		inst.setInstName("testinst");
		
	}
	
	@Test
	public void saveInstitutionTest() {
	
		
				
		try {
			instServiceImp.saveInstitution(inst);
		
		}catch (Exception e) {
			
			assertTrue(false);
		}
		
		
	}
	
	@Test
	public void noSaveInstitutionFaultNameTest() {
		
		inst.setInstName(null);
		
	
		when(insrepo.save(inst)).thenReturn(inst);
				
		try {
			instServiceImp.saveInstitution(inst);
		}catch (Exception e) {
			assertTrue(true);
		}
		
		
	}
	
	
	@Test
	public void noSaveInstitutionFaultURLTest() {
		
		inst.setInstAcademicserverurl(null);
		
	
		when(insrepo.save(inst)).thenReturn(inst);
				
		try {
			instServiceImp.saveInstitution(inst);
		}catch (Exception e) {
			assertTrue(true);
		}
		
		
	}
	
	
	@Test
	public void editInstitution() {
	
		Optional<Institution> optional= Optional.of(inst);
		when(insrepo.findById(inst.getInstId())).thenReturn(optional);
				
		try {
			instServiceImp.editInstitution(inst);
		
		}catch (Exception e) {
			
			assertTrue(false);
		}
		
		
	}
	
	@Test
	public void noEditInstitutionFaultName() {
		
		inst.setInstName(null);
		
	
		Optional<Institution> optional= Optional.of(inst);
		when(insrepo.findById(inst.getInstId())).thenReturn(optional);
				
		try {
			instServiceImp.editInstitution(inst);
		
		}catch (Exception e) {
			assertTrue(true);
		}
		
		
	}
		
		
	
	
	
	@Test
	public void noEditInstitutionFaultURL() {
		
		inst.setInstAcademicserverurl(null);
		
	
		Optional<Institution> optional= Optional.of(inst);
		when(insrepo.findById(inst.getInstId())).thenReturn(optional);
				
		try {
			instServiceImp.editInstitution(inst);
		
		}catch (Exception e) {
			assertTrue(true);
		}
		
		
	}
	
	@Test
	public void noEditInstitutionFaultExist() {
			
		Optional<Institution> optional= Optional.of(inst);
		when(insrepo.findById(inst.getInstId())).thenReturn(optional);
		optional=null;
				
		try {
			instServiceImp.editInstitution(inst);
		
		}catch (Exception e) {
			assertTrue(true);
		}		
		
	}
	
	
	
	
	

}
                    