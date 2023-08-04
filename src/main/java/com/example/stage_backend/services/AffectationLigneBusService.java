package com.example.stage_backend.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.stage_backend.dao.AffectationLigneBusRepository;
import com.example.stage_backend.entities.AffectationLigneBus;

import java.util.List;
import java.util.Optional;

@Service
public class AffectationLigneBusService {

    private final AffectationLigneBusRepository affectationLigneBusRepository;

    @Autowired
    public AffectationLigneBusService(AffectationLigneBusRepository affectationLigneBusRepository) {
        this.affectationLigneBusRepository = affectationLigneBusRepository;
    }

    public List<AffectationLigneBus> getAllAffectations() {
        return affectationLigneBusRepository.findAll();
    }

    public Optional<AffectationLigneBus> getAffectationById(Long id) {
        return affectationLigneBusRepository.findById(id);
    }

    public AffectationLigneBus createAffectation(AffectationLigneBus affectationLigneBus) {
        return affectationLigneBusRepository.save(affectationLigneBus);
    }

    public AffectationLigneBus updateAffectation(Long id, AffectationLigneBus updatedAffectation) {
        Optional<AffectationLigneBus> existingAffectation = affectationLigneBusRepository.findById(id);
        if (existingAffectation.isPresent()) {
            AffectationLigneBus affectationLigneBus = existingAffectation.get();
            affectationLigneBus.setAnneeScolaire(updatedAffectation.getAnneeScolaire());
            affectationLigneBus.setListDesLignes(updatedAffectation.getListDesLignes());
            affectationLigneBus.setListDesBus(updatedAffectation.getListDesBus());
            affectationLigneBus.setListDesChauffeurs(updatedAffectation.getListDesChauffeurs());
            return affectationLigneBusRepository.save(affectationLigneBus);
        }
        return null; // You can handle error cases as needed, e.g., throw an exception.
    }

    public void deleteAffectation(Long id) {
        affectationLigneBusRepository.deleteById(id);
    }
    
    
    
    

    public void archiverAffectationLigneBus(Long AffectationLigneBusId) {
    	AffectationLigneBus affectationLigneBus = affectationLigneBusRepository.findById(AffectationLigneBusId).orElse(null);

        if (affectationLigneBus != null) {
        	affectationLigneBus.setEtat("archiver");
            affectationLigneBusRepository.save(affectationLigneBus);
        } else {
            throw new IllegalArgumentException("Bus with ID " + AffectationLigneBusId + " does not exist.");
        }
    }

    public void activerAffectationLigneBus(Long AffectationLigneBusId) {
    	AffectationLigneBus affectationLigneBus = affectationLigneBusRepository.findById(AffectationLigneBusId).orElse(null);

        if (affectationLigneBus != null) {
        	affectationLigneBus.setEtat("activer");
        	affectationLigneBusRepository.save(affectationLigneBus);
        } else {
            throw new IllegalArgumentException("Bus with ID " + AffectationLigneBusId + " does not exist.");
        }
    }
    
    public List<AffectationLigneBus> getAllAffectationLigneBusEtatActiver() {
        return affectationLigneBusRepository.findByEtat("activer", Sort.by(Sort.Direction.ASC, "id"));
    }

    public List<AffectationLigneBus> getAllAffectationLigneBusEtatArchiver() {
        return affectationLigneBusRepository.findByEtat("archiver", Sort.by(Sort.Direction.ASC, "id"));
    }

    
    
    
}
