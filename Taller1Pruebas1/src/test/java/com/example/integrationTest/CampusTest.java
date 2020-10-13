package com.example.integrationTest;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
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
import com.example.repository.CampusRepository;
import com.example.repository.InstitutionRepository;
import com.example.services.CampusServiceImp;

@ExtendWith(SpringExtension.class)
@SpringBootTest  
class CampusTest {

	private Institution ins;
	private Institutioncampus campus;
	
	@Autowired
	private CampusServiceImp camSer;
	
	@BeforeEach
	private void setup() {
		
	
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
		
		
		try {
			camSer.saveCampus(campus);
		
		}catch (Exception e) {
			
			assertTrue(false);
		}	
	}
	
	
	public void editCampusTest() throws Exception{
		
		camSer.saveCampus(campus);
		
		campus.setInstcamName("edited");
		
		
		try {
			camSer.editCampus(campus);
		
		}catch (Exception e) {
			
			assertTrue(false);
		}	
	}
	
	
	
}
