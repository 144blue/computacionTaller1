package com.example.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.ServiceImpException;
import com.example.model.Institution;
import com.example.repository.InstitutionRepository;

import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
public class InstitutionServiceImp implements InstitutionService{

	private InstitutionRepository insrepo;
	
	@Autowired
	public InstitutionServiceImp(InstitutionRepository insrepo) {
		this.insrepo=insrepo;
	}
	
	@Override
	public Institution saveInstitution(Institution ins) throws Exception{
		
		String prefix="https://";
		Exception f= new ServiceImpException();
		
			if(ins.getInstName()!=null & ins.getInstAcademicserverurl().startsWith(prefix) & ins.getInstAcadextradataurl().startsWith(prefix) & ins.getInstAcadloginurl().startsWith(prefix)
					& ins.getInstAcadpersoninfodocurl().startsWith(prefix) & ins.getInstAcadpersoninfoidurl().startsWith(prefix)& ins.getInstAcadphysicalspacesurl().startsWith(prefix)
					& ins.getInstAcadphysicalspacesurl().startsWith(prefix)) {
				insrepo.save(ins);
				
			}else {
				log.info("no fue posible guardar la institucion");
				throw f;
			}
		
		
		return ins;
	}
	
	@Override
	public Institution editInstitution(Institution ins) throws Exception{
		Exception f= new ServiceImpException();
		Optional<Institution> antigua= insrepo.findById(ins.getInstId());
		String prefix="https://";
		Institution instii;
		
			if (antigua!=null) {
				if(ins.getInstName()!=null & ins.getInstAcademicserverurl().startsWith(prefix) & ins.getInstAcadextradataurl().startsWith(prefix) & ins.getInstAcadloginurl().startsWith(prefix)
						& ins.getInstAcadpersoninfodocurl().startsWith(prefix) & ins.getInstAcadpersoninfoidurl().startsWith(prefix)& ins.getInstAcadphysicalspacesurl().startsWith(prefix)
						& ins.getInstAcadphysicalspacesurl().startsWith(prefix)) {
					instii=antigua.get();
					instii=ins;
				}else {
					log.info("no fue posible editar la institucion");
					throw f;
				}
			}else {
				log.info("no fue posible editar la institucion");
				throw f;
			}
		return ins;
	}

}
