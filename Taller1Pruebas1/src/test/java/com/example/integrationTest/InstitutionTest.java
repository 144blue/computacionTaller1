package com.example.integrationTest;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.model.Institution;
import com.example.repository.InstitutionRepository;
import com.example.services.InstitutionServiceImp;
	
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.*;



@ExtendWith(SpringExtension.class)
@SpringBootTest  
class InstitutionTest {
	
	
	private Institution inst;

	
	
	@Autowired
	private InstitutionServiceImp instServiceImp;
	
	
	@BeforeEach
	private void setup() {
		
		
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
			fail();
		}
		
		
	}
	

	@Test
	public void editInstitution() {
	
		
		try {
			instServiceImp.saveInstitution(inst);
			
			inst.setInstName("edited");
			instServiceImp.editInstitution(inst);
		
		}catch (Exception e) {
			fail();
		}
		
		
	}
	
	
	
	
	

}
                    