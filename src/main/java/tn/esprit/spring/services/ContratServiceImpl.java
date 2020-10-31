package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {

	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);
	@Autowired
	ContratRepository contratRepository;
	


	public List<Contrat> getAllContrats() {
		l.info("In  getAllContrats : "); 
		List<Contrat> contrats = (List<Contrat>) contratRepository.findAll();  
		for (Contrat contrat : contrats) {
			l.debug("contrat +++ : " + contrat);
		}
		l.info("Out of getAllContrats."); 
		return contrats;
	
	}


	@Override
	public Contrat addContrat(Contrat c) {
		l.info("In  addContrat : " + c); 
		Contrat contratSaved = contratRepository.save(c);
		l.info("Out of  addContrat. "); 
		return contratSaved; 
	}


	@Override
	public Contrat updateContrat(Contrat c) {
		l.info("In  updateContrat : " + c);
		Contrat contratUpdated = contratRepository.save(c);
		l.info("Out of  updateContrat. "); 
		return contratUpdated;
		
	}


	@Override
	public void deleteContrat(Integer id) {
		l.info("in  deleteContrat id = " + id);
		contratRepository.deleteById(id);
		l.info("contrat deleted : " + id);
		
	}


	@Override
	public Contrat retrieveContrat(Integer id) {
		l.info("in  retrieveContrat id = " + id);
		Contrat c =  contratRepository.findById(id).orElse(null);
		l.info("contrat returned : " + c);
		return c; 
	}

}
