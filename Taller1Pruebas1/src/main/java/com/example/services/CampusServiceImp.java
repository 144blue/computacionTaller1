package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.ServiceImpException;
import com.example.model.Institution;
import com.example.model.Institutioncampus;
import com.example.repository.CampusRepository;
import com.example.repository.InstitutionRepository;

import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
public class CampusServiceImp implements CampusService{

	private CampusRepository camrepo;
	private InstitutionRepository insrepo;
	
	@Autowired
	public CampusServiceImp(CampusRepository camrepo, InstitutionRepository insrepo) {
		this.camrepo=camrepo;
		this.insrepo=insrepo;
	}
	
	
	@Override
	public Institutioncampus saveCampus(Institutioncampus icampus) throws Exception{
		Exception f= new ServiceImpException();
		
			if (icampus.getInstcamName()!=null& icampus.getInstcamOccupation().intValue()==0) {
				Institution camIns=insrepo.findById(icampus.getInstitution().getInstId()).get();
				if(camIns!=null) {
					camrepo.save(icampus);
				}else {
					log.info("no se pudo guardar el campus, no tiene institucion");
					throw f;
				}
				
			}else {
				log.info("no se pudo guardar el campus, no tiene nombre o ya esta ocupado");
				throw f;
			}

		return icampus;
	}

	@Override
	public Institutioncampus editCampus(Institutioncampus icampus) throws Exception{
		
		Exception f= new ServiceImpException();
			Institutioncampus instCampus= camrepo.findById(icampus.getInstcamId()).get();
			
			if (instCampus!=null &icampus.getInstcamName()!=null& icampus.getInstcamOccupation().intValue()==0) {
				Optional<Institution> camIns=insrepo.findById(icampus.getInstitution().getInstId());
				if(camIns!=null) {
					camrepo.save(icampus);
				}else {
					log.info("no se pudo editar el campus, no tiene institucion");
					throw f;
				}
				
			}else {
				log.info("no se pudo editar el campus, no tiene nombre o ya esta ocupado");
				throw f;
			}
		
		
		return icampus;
	}

}
