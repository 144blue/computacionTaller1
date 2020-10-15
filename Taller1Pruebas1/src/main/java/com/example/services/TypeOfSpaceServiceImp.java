package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.ServiceImpException;
import com.example.model.Institution;
import com.example.model.Institutioncampus;
import com.example.model.Physicalspacetype;
import com.example.repository.InstitutionRepository;
import com.example.repository.TypeOfSpaceRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class TypeOfSpaceServiceImp implements TypeOfSpaceService{
	
	private TypeOfSpaceRepository TypeRepo;
	private InstitutionRepository insRepo;
	
	@Autowired
	public TypeOfSpaceServiceImp(TypeOfSpaceRepository TypeRepo, InstitutionRepository insRepo) {
		this.TypeRepo=TypeRepo;
		this.insRepo=insRepo;
	}

	@Override
	public Physicalspacetype savePhysicalspacetype(Physicalspacetype PSType) throws Exception{
		
			ServiceImpException f=new ServiceImpException();
			Optional<Institution> inst= insRepo.findById(PSType.getInstitution().getInstId());
			
			if(inst!=null) {
				
				if (PSType.getPhyspctypeName()!=null) {
					System.out.println("enter");
					TypeRepo.save(PSType);
				}else {
					log.info("no fue posible guardar el tipo de espacio, no tiene nombre");
					throw f;
				}
			}else {
				log.info("no fue posible guardar el tipo de espacio, no tiene una istitucion asosciada");
				throw f;
			}
	
		
		return PSType;
	}

	@Override
	public Physicalspacetype editpPhysicalspacetype(Physicalspacetype PSType) throws Exception{

		
		ServiceImpException f=new ServiceImpException();
		
			Physicalspacetype phy;
			Optional<Physicalspacetype> old= TypeRepo.findById(PSType.getPhyspctypeId());
			Optional<Institution> inst= insRepo.findById(PSType.getInstitution().getInstId());
			
			if (old!=null) {
				if (inst != null) {
					if (PSType.getPhyspctypeName() != null) {
																
						phy=old.get();
						phy=PSType;
						
						
					} else {
						log.info("no fue posible actualizar el tipo de espacio, no tiene nombre");
						throw f;
					}
				} else {
					log.info("no fue posible actualizar el tipo de espacio, no tiene una istitucion asosciada");
					throw f;
				} 
			}else {
				log.info("no fue posible actualizar el tipo de espacio");
				throw f;
			}
		
		
		return PSType;
	}

}
