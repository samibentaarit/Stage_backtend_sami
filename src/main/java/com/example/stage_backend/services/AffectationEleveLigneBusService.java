package com.example.stage_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.stage_backend.dao.AffectationEleveLigneBusRepository;
import com.example.stage_backend.entities.AffectationEleveLigneBus;

import java.util.List;
import java.util.Optional;

@Service
public class AffectationEleveLigneBusService {

    private final AffectationEleveLigneBusRepository affectationEleveLigneBusRepository;

    @Autowired
    public AffectationEleveLigneBusService(AffectationEleveLigneBusRepository affectationEleveLigneBusRepository) {
        this.affectationEleveLigneBusRepository = affectationEleveLigneBusRepository;
    }

    public List<AffectationEleveLigneBus> getAllAffectations() {
        return affectationEleveLigneBusRepository.findAll();
    }

    public Optional<AffectationEleveLigneBus> getAffectationById(Long id) {
        return affectationEleveLigneBusRepository.findById(id);
    }

    public AffectationEleveLigneBus createAffectation(AffectationEleveLigneBus affectationEleveLigneBus) {
        return affectationEleveLigneBusRepository.save(affectationEleveLigneBus);
    }

    public AffectationEleveLigneBus updateAffectation(Long id, AffectationEleveLigneBus updatedAffectation) {
        Optional<AffectationEleveLigneBus> existingAffectation = affectationEleveLigneBusRepository.findById(id);
        if (existingAffectation.isPresent()) {
            AffectationEleveLigneBus affectationEleveLigneBus = existingAffectation.get();
            affectationEleveLigneBus.setAnneeScolaire(updatedAffectation.getAnneeScolaire());
            affectationEleveLigneBus.setEleves(updatedAffectation.getEleves());
            affectationEleveLigneBus.setListDesLignes(updatedAffectation.getListDesLignes());
            affectationEleveLigneBus.setListDesBus(updatedAffectation.getListDesBus());
            affectationEleveLigneBus.setStationAller(updatedAffectation.getStationAller());
            affectationEleveLigneBus.setStationRetour(updatedAffectation.getStationRetour());
            return affectationEleveLigneBusRepository.save(affectationEleveLigneBus);
        }
        return null; // You can handle error cases as needed, e.g., throw an exception.
    }

    public void deleteAffectation(Long id) {
        affectationEleveLigneBusRepository.deleteById(id);
    }
    
    

    public void archiverAffectationEleveLigneBus(Long affectationEleveLigneBusId) {
    	AffectationEleveLigneBus affectationEleveLigneBus = affectationEleveLigneBusRepository.findById(affectationEleveLigneBusId).orElse(null);

        if (affectationEleveLigneBus != null) {
        	affectationEleveLigneBus.setEtat("archiver");
        	affectationEleveLigneBusRepository.save(affectationEleveLigneBus);
        } else {
            throw new IllegalArgumentException("Bus with ID " + affectationEleveLigneBusId + " does not exist.");
        }
    }

    public void activerAffectationEleveLigneBus(Long affectationEleveLigneBusId) {
    	AffectationEleveLigneBus affectationEleveLigneBus = affectationEleveLigneBusRepository.findById(affectationEleveLigneBusId).orElse(null);

        if (affectationEleveLigneBus != null) {
        	affectationEleveLigneBus.setEtat("activer");
        	affectationEleveLigneBusRepository.save(affectationEleveLigneBus);
        } else {
            throw new IllegalArgumentException("Bus with ID " + affectationEleveLigneBusId + " does not exist.");
        }
    }
    public List<AffectationEleveLigneBus> getAllAffectationEleveLigneBusEtatActiver() {
        return affectationEleveLigneBusRepository.findByEtat("activer", Sort.by(Sort.Direction.ASC, "id"));
    }

    public List<AffectationEleveLigneBus> getAllAffectationEleveLigneBusEtatArchiver() {
        return affectationEleveLigneBusRepository.findByEtat("archiver", Sort.by(Sort.Direction.ASC, "id"));
    }
    
}
