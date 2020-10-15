package com.example.services;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.ServiceImpException;
import com.example.model.Institutioncampus;
import com.example.model.Physicalspace;
import com.example.model.Physicalspacetype;
import com.example.repository.CampusRepository;
import com.example.repository.PhysicSpaceRepository;
import com.example.repository.TypeOfSpaceRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PhysicSpaceServiceImp implements physicSpaceService{

	private CampusRepository campusRepo;
	private PhysicSpaceRepository phyRepo;
	private TypeOfSpaceRepository phyTypeRepo;
	
	@Autowired
	public PhysicSpaceServiceImp(CampusRepository campusRepo, PhysicSpaceRepository phyRepo, TypeOfSpaceRepository phyTypeRepo) {
		this.campusRepo=campusRepo;
		this.phyRepo=phyRepo;
		this.phyTypeRepo=phyTypeRepo;
	}
	
	@Override
	public Physicalspace savePhysicSpace(Physicalspace pSpace) throws Exception{
		
		ServiceImpException f=new ServiceImpException();
			Optional<Institutioncampus> oldC=campusRepo.findById(pSpace.getInstitutioncampus().getInstcamId());
			Optional<Physicalspacetype> oldPT=phyTypeRepo.findById(pSpace.getPhysicalspacetype().getPhyspctypeId());
			
			if (oldC!=null & oldPT!= null& (pSpace.getPhyspcExtid()==null||pSpace.getPhyspcExtid().length()==5)&pSpace.getPhysicalspace()==null) {
				phyRepo.save(pSpace);
			}else {
				log.info("informacion no completa, falta el campus, o el tipo de espacio");
				throw f;
			}
		
		
		
		return pSpace;
	}

	@Override
	public Physicalspace editPhysicalspace(Physicalspace pSpace) throws Exception{
		
			Physicalspace phy;
		ServiceImpException f=new ServiceImpException();
			Optional<Physicalspace> oldP= phyRepo.findById(pSpace.getPhyspcId());
			Optional<Institutioncampus> oldC=campusRepo.findById(pSpace.getInstitutioncampus().getInstcamId());
			Optional<Physicalspacetype> oldPT=phyTypeRepo.findById(pSpace.getPhysicalspacetype().getPhyspctypeId());
									
			if (oldP!=null& (pSpace.getPhyspcExtid()==null||pSpace.getPhyspcExtid().length()==5)&pSpace.getPhysicalspace()==null) {
				if (oldC != null & oldPT != null) {
					phy=oldP.get();
					phy=pSpace;
				} else {
					log.info("informacion no completa, falta el campus, o el tipo de espacio");
					throw f;
				} 
			}else {
				log.info("no fue posible actualizar el espacio fisico" );
				throw f;
			}
		
			
		return pSpace;
	}

}
